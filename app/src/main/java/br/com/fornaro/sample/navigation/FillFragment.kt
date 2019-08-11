package br.com.fornaro.sample.navigation

import android.location.Location
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_fill.*

class FillFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_fill, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button.setOnClickListener {
            val direction = FillFragmentDirections.filledFragment(
                if (integerEditText.text.isEmpty()) 0 else integerEditText.text.toString().toInt(),
                textEditText.text.toString(),
                if (decimalEditText.text.isEmpty()) 0f else decimalEditText.text.toString().toFloat(),
                booleanValue.isChecked,
                Location("provider").apply {
                    latitude = 2.0
                    longitude = 3.0
                },
                SomeObj("title","description"),
                SomeEnum.VALUE_1
            )
            view.findNavController().navigate(direction)
        }
    }
}
