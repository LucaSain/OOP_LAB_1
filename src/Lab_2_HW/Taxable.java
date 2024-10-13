package Lab_2_HW;

public interface Taxable {
    double VAT = 0.19;

    double computeVAT();
    double computeRoadTax();
    double computeCustomTax();
    double computeTotalTax();
}
