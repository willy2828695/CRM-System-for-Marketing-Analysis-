
package model.MarketingManagement;

import java.util.ArrayList;

import model.Business.Business;
import model.Personnel.Person;

public class MarketingPersonDirectory {

    Business business;
    ArrayList<MarketingPersonProfile> marketingPersonList;

    public MarketingPersonDirectory(Business d) {
        business = d;
        marketingPersonList = new ArrayList<MarketingPersonProfile>();
    }

    public MarketingPersonProfile newMarketingPersonProfile(Person p) {
        MarketingPersonProfile sp = new MarketingPersonProfile(p);
        marketingPersonList.add(sp);
        return sp;
    }

    public MarketingPersonProfile findMarketingPerson(String id) {

        for (MarketingPersonProfile sp : marketingPersonList) {

            if (sp.isMatch(id)) {
                return sp;
            }
        }
        return null; // not found after going through the whole list
    }

}
