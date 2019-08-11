package br.com.fornaro.sample.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_filled.*

class FilledFragment : Fragment() {

    private val args: FilledFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_filled, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textView.text = "Integer: ${args.someInteger}\n" +
                "Text: ${args.someText}\n" +
                "Decimal: ${args.someDecimal}\n" +
                "Boolean: ${args.someBoolean}\n" +
                "Location: ${args.someLocation.toString()}\n" +
                "Obj: ${args.someObj.toString()}\n" +
                "Enum: ${args.someEnum?.name}"
    }
}
