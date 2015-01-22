/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.exception;

/**
 *
 * @author Matteo
 */
public class InvalidDateException extends Exception {
    public InvalidDateException() {
        super("Start date after end date");
    }
}
