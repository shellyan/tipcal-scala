package luc.edu.tipcal

import _root_.android.app.Activity
import _root_.android.os.Bundle
import android.widget.TextView.OnEditorActionListener
import android.widget.TextView
import android.view.KeyEvent
import android.util.Log

class MainActivity extends Activity with TypedActivity {
  lazy val textview = findView(TR.textview)
  lazy val billAmount = findView(TR.billAmount)
  lazy val tipAmount = findView(TR.tipAmount)
  lazy val billTotal = findView(TR.billTotal)
  lazy val radioGroup1 = findView(TR.radioGroup1)

  lazy val tipModel = new TipModel()

  override def onCreate(bundle: Bundle) {
    super.onCreate(bundle)
    setContentView(R.layout.main)

    textview.setText("Code in Scala")

    billAmount.setOnEditorActionListener(
      new OnEditorActionListener() {
        def onEditorAction(textView: TextView, actionId: Int, e: KeyEvent) = {
          Log.e(getClass.getName, "onEditorAction:" + actionId + e)
          if (e.getAction() == KeyEvent.ACTION_DOWN) {
            billAmountEditingDone()
            changeWasObserved(tipModel)
//            textview.setText("radio"+tipModel.getBillAmount+"+"+tipModel.getTipAmount)
            true
          } else false
        }
      })
      

  }

  def billAmountEditingDone() = {
    lazy val id=radioGroup1.getCheckedRadioButtonId()
    if(id == TR.tip15.id) tip15Clicked()
    if(id == TR.tip18.id) tip18Clicked()
    if(id == TR.tip20.id) tip20Clicked()
    
    var amount: Float = 0
    try {
      amount = billAmount.getText().toString().toFloat
    } catch {
      case e: Exception => amount
    }
    tipModel.setBillAmount(amount);

  }

  def tip15Clicked() = tipModel.setTipRate(0.15f);
  def tip18Clicked() = tipModel.setTipRate(0.18f);
  def tip20Clicked() = tipModel.setTipRate(0.20f);

  def changeWasObserved(theTipModel: TipModel) = {
    val tipAmountString = tipModel.getTipAmount().formatted("%.2f")
    val billTotalString = tipModel.getBillTotal().formatted("%.2f")
    tipAmount.setText(tipAmountString);
    billTotal.setText(billTotalString);
  }

}
