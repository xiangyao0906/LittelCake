package com.xinly.cake.model.vo.result;

/**
 * Created by zm on 2019-11-04.
 */
public class AppSettingsData {

    private WalletBean wallet;
    private RadBean rad;
    private ClashBean clash;
    private CoreBen core;

    public CoreBen getCore() {
        return core;
    }

    public void setCore(CoreBen core) {
        this.core = core;
    }

    public WalletBean getWallet() {
        return wallet;
    }

    public void setWallet(WalletBean wallet) {
        this.wallet = wallet;
    }

    public RadBean getRad() {
        return rad;
    }

    public void setRad(RadBean rad) {
        this.rad = rad;
    }

    public ClashBean getClash() {
        return clash;
    }

    public void setClash(ClashBean clash) {
        this.clash = clash;
    }

    public static class WalletBean {

        private double ridInvite;
        private double ridOrigin;
        private String chainTransferTaxMin;
        private String chainTransferTaxMax;
        private String chainTransferTaxToken;

        public String getChainTransferTaxToken() {
            return chainTransferTaxToken;
        }

        public void setChainTransferTaxToken(String chainTransferTaxToken) {
            this.chainTransferTaxToken = chainTransferTaxToken;
        }

        public double getRidInvite() {
            return ridInvite;
        }

        public void setRidInvite(double ridInvite) {
            this.ridInvite = ridInvite;
        }

        public double getRidOrigin() {
            return ridOrigin;
        }

        public void setRidOrigin(double ridOrigin) {
            this.ridOrigin = ridOrigin;
        }

        public String getChainTransferTaxMin() {
            return chainTransferTaxMin;
        }

        public void setChainTransferTaxMin(String chainTransferTaxMin) {
            this.chainTransferTaxMin = chainTransferTaxMin;
        }

        public String getChainTransferTaxMax() {
            return chainTransferTaxMax;
        }

        public void setChainTransferTaxMax(String chainTransferTaxMax) {
            this.chainTransferTaxMax = chainTransferTaxMax;
        }
    }

    public static class RadBean {

        private double minPrice;
        private double minPriceRatio;
        private double tax;

        public double getTax() {
            return tax;
        }

        public void setTax(double tax) {
            this.tax = tax;
        }

        public double getMinPrice() {
            return minPrice;
        }

        public void setMinPrice(double minPrice) {
            this.minPrice = minPrice;
        }

        public double getMinPriceRatio() {
            return minPriceRatio;
        }

        public void setMinPriceRatio(double minPriceRatio) {
            this.minPriceRatio = minPriceRatio;
        }
    }

    public static class ClashBean {

        private double min;
        private double tax;

        public double getMin() {
            return min;
        }

        public void setMin(double min) {
            this.min = min;
        }

        public double getTax() {
            return tax;
        }

        public void setTax(double tax) {
            this.tax = tax;
        }
    }

    public static class CoreBen {
        private String helpUrl;

        public String getHelpUrl() {
            return helpUrl;
        }

        public void setHelpUrl(String helpUrl) {
            this.helpUrl = helpUrl;
        }
    }
}
