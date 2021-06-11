/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

/**
 *
 * @author User
 */
 public class ComboItem
{
    private String key;
    private int[] value;

    public ComboItem(String key, int[] value)
    {
        this.key = key;
        this.value = value;
    }

    ComboItem(String até_49_anos, int resultado1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString()
    {
        return key;
    }

    public String getKey()
    {
        return key;
    }

    public int[] getValue()
    {
        return value;
    }
}

