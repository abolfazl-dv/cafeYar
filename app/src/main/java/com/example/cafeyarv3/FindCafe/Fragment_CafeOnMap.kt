package com.example.cafeyarv3.FindCafe

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import com.example.cafeyarv3.CafeDetail.CafeDetailActivity
import com.example.cafeyarv3.Filter.Fragment_Search_Filter
import com.example.cafeyarv3.MainActivity
import com.example.cafeyarv3.R
import com.example.cafeyarv3.databinding.AnnotationViewMapBinding
import com.example.cafeyarv3.databinding.FragmentCafeonmapBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mapbox.android.gestures.MoveGestureDetector
import com.mapbox.geojson.Point
import com.mapbox.maps.CameraOptions
import com.mapbox.maps.MapboxMap
import com.mapbox.maps.Style
import com.mapbox.maps.extension.style.expressions.dsl.generated.interpolate
import com.mapbox.maps.extension.style.style
import com.mapbox.maps.plugin.LocationPuck2D
import com.mapbox.maps.plugin.annotation.annotations
import com.mapbox.maps.plugin.annotation.generated.OnPointAnnotationClickListener
import com.mapbox.maps.plugin.annotation.generated.PointAnnotation
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationOptions
import com.mapbox.maps.plugin.annotation.generated.createPointAnnotationManager
import com.mapbox.maps.plugin.compass.CompassView
import com.mapbox.maps.plugin.compass.compass
import com.mapbox.maps.plugin.compass.generated.CompassSettings
import com.mapbox.maps.plugin.compass.generated.CompassSettingsBase
import com.mapbox.maps.plugin.compass.generated.CompassSettingsInterface
import com.mapbox.maps.plugin.gestures.OnMoveListener
import com.mapbox.maps.plugin.gestures.gestures
import com.mapbox.maps.plugin.gestures.getGesturesSettings
import com.mapbox.maps.plugin.locationcomponent.OnIndicatorBearingChangedListener
import com.mapbox.maps.plugin.locationcomponent.OnIndicatorPositionChangedListener
import com.mapbox.maps.plugin.locationcomponent.location
import com.mapbox.maps.viewannotation.ViewAnnotationManager
import com.mapbox.maps.viewannotation.viewAnnotationOptions
import java.lang.ref.WeakReference

/**
 * Created by abolfazl_dv on 25,April,2022
 */
class Fragment_CafeOnMap : Fragment() {
    //
    private val CHOOSED_POINT: Point = Point.fromLngLat(50.99007588330862, 35.82118014868266)
    lateinit var binding: FragmentCafeonmapBinding
    private lateinit var viewAnnotationManager: ViewAnnotationManager


    //
    private lateinit var locationPermissionHelper: LocationPermissionHelper
    var points = arrayListOf<Point>()

    //
    private val onIndicatorBearingChangedListener = OnIndicatorBearingChangedListener {
        binding.cafeOnMapMapView.getMapboxMap()
            .setCamera(CameraOptions.Builder().bearing(it).build())
    }

    //
    private val onIndicatorPositionChangedListener = OnIndicatorPositionChangedListener {
        binding.cafeOnMapMapView.getMapboxMap()
            .setCamera(CameraOptions.Builder().center(it).build())
        binding.cafeOnMapMapView.gestures.focalPoint =
            binding.cafeOnMapMapView.getMapboxMap().pixelForCoordinate(it)
    }

    //
    private val onMoveListener = object : OnMoveListener {

        override fun onMoveBegin(detector: MoveGestureDetector) {
            onCameraTrackingDismissed()
        }

        override fun onMove(detector: MoveGestureDetector): Boolean {
            return false
        }

        override fun onMoveEnd(detector: MoveGestureDetector) {

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCafeonmapBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnCafeOnList = view.findViewById<FloatingActionButton>(R.id.FAbCafeMapToCafeList)
        val btnFilter = view.findViewById<FloatingActionButton>(R.id.FABCafeOnMapFilter)

        //
        locationPermissionHelper = LocationPermissionHelper(WeakReference(this.activity))
        viewAnnotationManager = binding.cafeOnMapMapView.viewAnnotationManager
        locationPermissionHelper.checkPermission {
            onMapReady()
        }
        //
        val mainActivity = (activity as MainActivity)
        btnCafeOnList.setOnClickListener {
            mainActivity.replaceFragment(Fragment_CafeOnList())
        }
        btnFilter.setOnClickListener {
            mainActivity.replaceFragment(Fragment_Search_Filter())
        }

    }

    ///
    private fun onMapReady() {
        binding.cafeOnMapMapView.getMapboxMap()
            .setCamera(CameraOptions.Builder().zoom(14.0).build())
        binding.cafeOnMapMapView.getMapboxMap().loadStyleUri(Style.MAPBOX_STREETS) {
            initLocationComponent()
            setupGesturesListener()
            addAnnotationToMap(points)
        }
        binding.cafeOnMapMapView.compass.position = Gravity.BOTTOM
    }

    ///
    private fun initLocationComponent() {
        val locationComponentPlugun = binding.cafeOnMapMapView.location
        locationComponentPlugun.updateSettings {
            this.enabled = true
            pulsingEnabled = true
            pulsingColor = R.color.gold
            pulsingMaxRadius = 25.0f
            this.locationPuck = LocationPuck2D(
                bearingImage = AppCompatResources.getDrawable(
                    requireContext(),
                    R.drawable.ic_marker
                ), scaleExpression = interpolate {
                    linear()
                    zoom()
                    stop {
                        literal(0.0)
                        literal(0.6)
                    }
                    stop {
                        literal(20.0)
                        literal(1.0)
                    }
                }.toJson()
            )
        }
        locationComponentPlugun.addOnIndicatorPositionChangedListener(
            onIndicatorPositionChangedListener
        )
        locationComponentPlugun.addOnIndicatorBearingChangedListener(
            onIndicatorBearingChangedListener
        )
    }

    ///
    private fun setupGesturesListener() {
        binding.cafeOnMapMapView.gestures.addOnMoveListener(onMoveListener)
    }

    ///
    private fun onCameraTrackingDismissed() {
        Toast.makeText(requireContext(), "On Camera Tracking Dismissed", Toast.LENGTH_SHORT).show()
        binding.cafeOnMapMapView.location.removeOnIndicatorPositionChangedListener(
            onIndicatorPositionChangedListener
        )
        binding.cafeOnMapMapView.location.removeOnIndicatorBearingChangedListener(
            onIndicatorBearingChangedListener
        )
        binding.cafeOnMapMapView.gestures.removeOnMoveListener(onMoveListener)
    }

    ///
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        locationPermissionHelper.onRequestPermissionResult(requestCode, permissions, grantResults)
    }

    ///
    private fun addAnnotationToMap(pointList: ArrayList<Point>) {
        bitmapFromDrawableRes(requireContext(), R.drawable.ic_marker)?.let {
            val annotationApi = binding.cafeOnMapMapView.annotations
            points.add(Point.fromLngLat(50.90967689692748, 35.807046198501915))
            points.add(Point.fromLngLat(50.90937868431015, 35.80775999497761))
            points.add(Point.fromLngLat(50.902324945845, 35.80841018871751))
            points.add(Point.fromLngLat(50.90229474644632, 35.80812756823974))
            points.add(Point.fromLngLat(50.898865, 35.803019))
            points.add(Point.fromLngLat(50.900241, 35.803108))
            points.add(Point.fromLngLat(50.908681, 35.797435))
            points.add(Point.fromLngLat(50.897490, 35.794594))
            points.add(Point.fromLngLat(50.898183, 35.794187))
            points.add(Point.fromLngLat(50.895686, 35.794634))
            val pointAnnotationManager =
                annotationApi.createPointAnnotationManager(binding.cafeOnMapMapView)
            for (i in points) {
                val lat = i.latitude()
                val lng = i.longitude()
                addViewAnnotation(i)
            }
        }
    }

    ///
    @SuppressLint("SetTextI18n")
    private fun addViewAnnotation(point: Point) {
        val viewAnnotation = viewAnnotationManager.addViewAnnotation(
            resId = R.layout.annotation_view_map,
            options = viewAnnotationOptions {
                geometry(point)
                allowOverlap(true)
            }
        )
        AnnotationViewMapBinding.bind(viewAnnotation).apply {
            markerText.setOnClickListener {
                val intentToDetail = Intent(requireContext(), CafeDetailActivity::class.java)
                startActivity(intentToDetail)

            }
        }
    }

    ///
    private fun bitmapFromDrawableRes(context: Context, @DrawableRes resourceId: Int) =
        convertDrawableToBitmap(AppCompatResources.getDrawable(context, resourceId))

    ///
    private fun convertDrawableToBitmap(sourceDrawable: Drawable?): Bitmap? {
        if (sourceDrawable == null) {
            return null
        }
        return if (sourceDrawable is BitmapDrawable) {
            sourceDrawable.bitmap
        } else {
            val constantState = sourceDrawable.constantState ?: return null
            val drawable = constantState.newDrawable().mutate()
            val bitmap: Bitmap = Bitmap.createBitmap(
                drawable.intrinsicWidth, drawable.intrinsicHeight, Bitmap.Config.ARGB_8888
            )
            val canvas = Canvas(bitmap)
            drawable.setBounds(0, 0, canvas.width, canvas.height)
            drawable.draw(canvas)
            bitmap
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.cafeOnMapMapView.location.removeOnIndicatorPositionChangedListener(
            onIndicatorPositionChangedListener
        )
        binding.cafeOnMapMapView.location.removeOnIndicatorBearingChangedListener(
            onIndicatorBearingChangedListener
        )
        binding.cafeOnMapMapView.gestures.removeOnMoveListener(onMoveListener)
    }

}
//
//val pointAnnotationOptions: PointAnnotationOptions = PointAnnotationOptions()
//    .withPoint(Point.fromLngLat(lng, lat))
//    .withIconImage(it)
//pointAnnotationManager.create(pointAnnotationOptions)