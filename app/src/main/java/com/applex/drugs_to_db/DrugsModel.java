package com.applex.drugs_to_db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "drug_details")
public class DrugsModel {

    @ColumnInfo(name = "ID")
    private int ID;

    @ColumnInfo(name = "NAME")
    private String name;

    @ColumnInfo(name = "MANUFACTURER")
    private String company_name;

    @ColumnInfo(name = "CONTENTS")
    private String contents;

    @ColumnInfo(name = "CIMS_CLASS")
    private String cims_class;

    @ColumnInfo(name = "ATC_CLASSIFICATION")
    private String atc_classification;

    @ColumnInfo(name = "FORM_1")
    private String form_1;

    @ColumnInfo(name = "PACKING_PRICE_1")
    private String packing_price_1;

    @ColumnInfo(name = "FORM_2")
    private String form_2;

    @ColumnInfo(name = "PACKING_PRICE_2")
    private String packing_price_2;

    @ColumnInfo(name = "FORM_3")
    private String form_3;

    @ColumnInfo(name = "PACKING_PRICE_3")
    private String packing_price_3;

    @ColumnInfo(name = "FORM_4")
    private String form_4;

    @ColumnInfo(name = "PACKING_PRICE_4")
    private String packing_price_4;

    @ColumnInfo(name = "FORM_5")
    private String form_5;

    @ColumnInfo(name = "PACKING_PRICE_5")
    private String packing_price_5;

    @ColumnInfo(name = "FORM_6")
    private String form_6;

    @ColumnInfo(name = "PACKING_PRICE_6")
    private String packing_price_6;

    @ColumnInfo(name = "FORM_7")
    private String form_7;

    @ColumnInfo(name = "PACKING_PRICE_7")
    private String packing_price_7;

    @ColumnInfo(name = "FORM_8")
    private String form_8;

    @ColumnInfo(name = "PACKING_PRICE_8")
    private String packing_price_8;

    @ColumnInfo(name = "FORM_9")
    private String form_9;

    @ColumnInfo(name = "PACKING_PRICE_9")
    private String packing_price_9;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getCims_class() {
        return cims_class;
    }

    public void setCims_class(String cims_class) {
        this.cims_class = cims_class;
    }

    public String getAtc_classification() {
        return atc_classification;
    }

    public void setAtc_classification(String atc_classification) {
        this.atc_classification = atc_classification;
    }

    public String getForm_1() {
        return form_1;
    }

    public void setForm_1(String form_1) {
        this.form_1 = form_1;
    }

    public String getPacking_price_1() {
        return packing_price_1;
    }

    public void setPacking_price_1(String packing_price_1) {
        this.packing_price_1 = packing_price_1;
    }

    public String getForm_2() {
        return form_2;
    }

    public void setForm_2(String form_2) {
        this.form_2 = form_2;
    }

    public String getPacking_price_2() {
        return packing_price_2;
    }

    public void setPacking_price_2(String packing_price_2) {
        this.packing_price_2 = packing_price_2;
    }

    public String getForm_3() {
        return form_3;
    }

    public void setForm_3(String form_3) {
        this.form_3 = form_3;
    }

    public String getPacking_price_3() {
        return packing_price_3;
    }

    public void setPacking_price_3(String packing_price_3) {
        this.packing_price_3 = packing_price_3;
    }

    public String getForm_4() {
        return form_4;
    }

    public void setForm_4(String form_4) {
        this.form_4 = form_4;
    }

    public String getPacking_price_4() {
        return packing_price_4;
    }

    public void setPacking_price_4(String packing_price_4) {
        this.packing_price_4 = packing_price_4;
    }

    public String getForm_5() {
        return form_5;
    }

    public void setForm_5(String form_5) {
        this.form_5 = form_5;
    }

    public String getPacking_price_5() {
        return packing_price_5;
    }

    public void setPacking_price_5(String packing_price_5) {
        this.packing_price_5 = packing_price_5;
    }

    public String getForm_6() {
        return form_6;
    }

    public void setForm_6(String form_6) {
        this.form_6 = form_6;
    }

    public String getPacking_price_6() {
        return packing_price_6;
    }

    public void setPacking_price_6(String packing_price_6) {
        this.packing_price_6 = packing_price_6;
    }

    public String getForm_7() {
        return form_7;
    }

    public void setForm_7(String form_7) {
        this.form_7 = form_7;
    }

    public String getPacking_price_7() {
        return packing_price_7;
    }

    public void setPacking_price_7(String packing_price_7) {
        this.packing_price_7 = packing_price_7;
    }

    public String getForm_8() {
        return form_8;
    }

    public void setForm_8(String form_8) {
        this.form_8 = form_8;
    }

    public String getPacking_price_8() {
        return packing_price_8;
    }

    public void setPacking_price_8(String packing_price_8) {
        this.packing_price_8 = packing_price_8;
    }

    public String getForm_9() {
        return form_9;
    }

    public void setForm_9(String form_9) {
        this.form_9 = form_9;
    }

    public String getPacking_price_9() {
        return packing_price_9;
    }

    public void setPacking_price_9(String packing_price_9) {
        this.packing_price_9 = packing_price_9;
    }
}