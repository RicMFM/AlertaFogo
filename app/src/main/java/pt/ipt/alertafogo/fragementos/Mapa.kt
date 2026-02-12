package pt.ipt.alertafogo.fragmentos

import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.overlay.Marker
import pt.ipt.alertafogo.R
import pt.ipt.alertafogo.databinding.FragmentMapaBinding
import pt.ipt.alertafogo.repositorio.FogosRepositorio

class Mapa : Fragment(R.layout.fragment_mapa) {

    private var _binding: FragmentMapaBinding? = null
    private val binding get() = _binding!!

    private val fogosRepository = FogosRepositorio()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMapaBinding.bind(view)

        // 1. Configurar OSMDroid
        Configuration.getInstance().load(
            requireContext(),
            PreferenceManager.getDefaultSharedPreferences(requireContext())
        )

        // 2. Configurar o mapa
        configurarMapa()

    }

    private fun configurarMapa() {
        binding.osmmap.apply {
            // Tipo de mapa
            setTileSource(TileSourceFactory.MAPNIK)

            // Permitir zoom e movimento
            setMultiTouchControls(true)

            // Posição inicial: Centro de Portugal
            controller.setZoom(7.0)
            controller.setCenter(GeoPoint(39.5, -8.0))
        }

        Log.d("Mapa", "Mapa configurado")
    }


    override fun onResume() {
        super.onResume()
        binding.osmmap.onResume()
    }

    override fun onPause() {
        super.onPause()
        binding.osmmap.onPause()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}