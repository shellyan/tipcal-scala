package luc.edu.tipcal
class TipModel {

  
    private var billAmount:Float =0
    private var tipRate:Float =0


    //~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Gets the amount of the bill, before the tip (the subtotal).
     *
     * @return the amount of the bill, before the tip
     */
    def  getBillAmount()=
    {
         billAmount
    }


    // ----------------------------------------------------------
    /**
     * Sets the amount of the bill, before the tip.
     *
     * @param newBillAmount the new amount of the bill before the tip
     */
    def  setBillAmount( newBillAmount:Float)
    {
        billAmount = newBillAmount
    }


    // ----------------------------------------------------------
    /**
     * Gets the tip rate, represented as a floating point value (for example,
     * a 15% tip would be 0.15).
     *
     * @return the tip rate
     */
    def  getTipRate()=
    {
         tipRate
    }


    // ----------------------------------------------------------
    /**
     * Sets the tip rate, represented as a floating point value (for example,
     * a 15% tip would be 0.15).
     *
     * @param newTipRate the new tip rate
     */
    def  setTipRate( newTipRate:Float)
    {
        tipRate = newTipRate
        
    }


    // ----------------------------------------------------------
    /**
     * Gets the absolute amount of the tip by itself, calculated by multiplying
     * the bill subtotal and the tip rate.
     *
     * @return the absolute amount of the tip by itself
     */
    def getTipAmount()=
    {
         billAmount * tipRate
    }


    // ----------------------------------------------------------
    /**
     * Gets the total amount of the bill, including the tip.
     *
     * @return the total amount of the bill, including the tip
     */
    def  getBillTotal()=
    {
        billAmount + getTipAmount()
    }
}