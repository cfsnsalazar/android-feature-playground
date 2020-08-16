package org.js.denisvieira.featureplayground.commons.formatter

//import br.com.concrete.canarinho.formatador.FormatadorValor
import org.js.denisvieira.featureplayground.commons.formatter.CurrencyFormatter.getFormattedCurrencyForLocale
import org.js.denisvieira.featureplayground.commons.formatter.CurrencyISOTypeConst.USA
// TODO refactor
//fun Float.formatAsRealCurrency() = FormatadorValor.VALOR_COM_SIMBOLO.formata(this.toString())

fun Float.formatAsDollarCurrency() = getFormattedCurrencyForLocale(this, USA)
