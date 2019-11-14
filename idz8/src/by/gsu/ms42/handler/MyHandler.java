package by.gsu.ms42.handler;

import by.gsu.ms42.pojo.Branch;
import by.gsu.ms42.pojo.Range;
import by.gsu.ms42.pojo.Rate;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MyHandler extends DefaultHandler {

    private static final String BRANCH_TAG = "branch";
    private static final String RATE_TAG = "rate";
    private static final String RANGE_TAG = "range";
    private static final String BUY_TAG = "buy";
    private static final String SELL_TAG = "sell";

    private static final String BRANCH_NAME_ATTRIBUTE = "name";
    private static final String RATE_CURRENCY_ATTRIBUTE = "currency";
    private static final String RANGE_MIN_AMOUNT_ATTRIBUTE = "min-amount";
    private static final String RANGE_MAX_AMOUNT_ATTRIBUTE = "max-amount";

    private String currentElement;
    private Branch branch;
    private Rate rate;
    private Range currentRange;
    private List<Branch> branchList = new ArrayList<>();


    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start...");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;

        switch (currentElement) {
            case BRANCH_TAG: {
                branch = new Branch();
                branch.setName(String.valueOf(attributes.getValue(BRANCH_NAME_ATTRIBUTE)));
                branchList.add(branch);
            }
            break;
            case RATE_TAG: {
                rate = new Rate();
                rate.setCurrency(String.valueOf(attributes.getValue(RATE_CURRENCY_ATTRIBUTE)));
            }
            break;
            case RANGE_TAG: {
                currentRange = new Range();
                currentRange.setMinAmount(Long.valueOf(attributes.getValue(RANGE_MIN_AMOUNT_ATTRIBUTE)));
                currentRange.setMaxAmount(Long.valueOf(attributes.getValue(RANGE_MAX_AMOUNT_ATTRIBUTE)));
            }
            break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String text = new String(ch, start, length);

        if (text.contains("<") || currentRange == null) {
            return;
        }

        switch (currentElement) {
            case BUY_TAG: {
                currentRange.setBuy(Double.valueOf(text));
            }
            break;
            case SELL_TAG: {
                currentRange.setSell(Double.valueOf(text));
            }
            break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName){
            case RATE_TAG: {
                branch.getRateList().add(rate);
                rate = null;
            }
            break;
            case RANGE_TAG: {
                rate.getRangeList().add(currentRange);
                currentRange = null;
            }
            break;
        }
        currentElement = "";
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("The end...");
    }

    public List<Branch> getBranchList() {
        return branchList;
    }
}
