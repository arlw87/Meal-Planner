package home;

import home.model.Ingredient;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Exports the generated shopping list to external files or applications. Uses Static methods.
 */

public class ExportShoppingList {

    /**
     * Write the generated shopping list to a text file. Shopping list includes the date the shopping list was
     * generated on, the ingredients of the shopping list and the quantity in grams and quantity amounts (for example
     * slices for bread, tins for chickpeas).
     *
     * @param shoppingList list of ingredients to write to the text file
     * @param fileName path of the text file to write too
     * @param generated Date and time as a string that the shopping list was generated on
     * @exception if there is an error when saving the text file
     */

    public static void writeToTextFile(List<Ingredient> shoppingList, String fileName, String generated) throws Exception {
        var out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(fileName, false) ,
                StandardCharsets.UTF_8));

            out.println("Shopping List generated on " + generated + "\n");

            for (Ingredient i: shoppingList){

                String quantityName = i.getQuantityName();
                double quantityInGrams = i.getQuantityInGrams();
                double quantityRatio = (quantityInGrams / i.getSingleQuantityInGrams());

                //for formatting quantity amounts
                DecimalFormat df = new DecimalFormat("#.#");
                DecimalFormat df2 = new DecimalFormat("#");

                if (quantityRatio > 1){
                    quantityName = quantityName + "s";
                }

                out.println( i.getName() + " ( " + df2.format(quantityInGrams) + " grams / "  +
                        df.format(quantityRatio) + " " + quantityName + ")");

            }



    }

}
