package model.ProductManagement;

public class SolutionOfferItem {
    SolutionOffer selectedOffer;
    int actualPrice;
    int quantity;

    public SolutionOfferItem(SolutionOffer sf, int paidprice, int q) {
        selectedOffer = sf;
        sf.addSolutionOfferItem(this); //make sure solution offer links back to the solution offer item
        quantity = q;
        this.actualPrice = paidprice;
    }

    public int getSolutionOfferItemTotal() {
        return actualPrice * quantity;
    }

//The following calculates what the price gain would have been if products were sold at target price
    public int getSolutionOfferItemTargetTotal() {
        return selectedOffer.getPrice() * quantity;
    }

    //returns positive if seller is making higher margin than target
    //returns negative if seller is making lower margin than target
    //otherwise zero meaning neutral
    public int calculatePricePerformance() {
        return (actualPrice - selectedOffer.getPrice()) * quantity;
    }

    public boolean isActualAboveTarget() {
        if (actualPrice > selectedOffer.getPrice()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isActualBelowTarget() {
        if (actualPrice < selectedOffer.getPrice()) {
            return true;
        } else {
            return false;
        }

    }

    public boolean isActualATTarget() {
        if (actualPrice == selectedOffer.getPrice()) {
            return true;
        } else {
            return false;
        }

    }

    public SolutionOffer getselectedOffer() {
        return selectedOffer;
    }

    public int getActualPrice() {
        return actualPrice;

    }

    public int getQuantity() {
        return quantity;
    }
}
