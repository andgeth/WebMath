package by.vsu.controllers;

abstract public class BaseController {

    double round(double value, int precision) {
        return Math.round(value * Math.pow(10, precision)) / Math.pow(10, precision);
    }

}
