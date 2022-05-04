import Storages.Storage;

import java.util.Scanner;


public class Main {

   public static void main(String[] args) {
      Storage st = new Storage();
      //st.showStore();

      System.out.println("Welcome to PC store\nThis storage is for computer components");
      while (true) {
         System.out.println(
                 """
                    ==Choose action:
                    1. Show Components.
                    2. Add component.
                    3. Change component.
                    4. Remove component.
                    5. Clear Storage.
                    6. Exit.""");
         System.out.println("Input answer: ");
         Scanner in = new Scanner(System.in);
         String answer = in.nextLine().toLowerCase();
         if (answer.contains("1") || answer.contains("show")) {
            if (st.isEmpties()) {
               System.out.println("\nStorage is Empty\n");
            } else {
               st.showStore();
            }
         } else if (answer.contains("2") || answer.contains("add")) {
            System.out.println("\n\tSelect the component you want to add:\n1. CPU.\n2. GPU\n3. RAM\n4. Motherboard.\n5.Power supply.\n6. Back.\n7. Exit\n\n");

            System.out.println("Input answer: ");
            answer = in.nextLine().toLowerCase();
            if (answer.contains("1") || answer.contains("cpu")) {

            } else if (answer.contains("6") || answer.contains("back")) {
               continue;
            } else if (answer.contains("7") || answer.contains("exit")) {
               System.out.println("Buy");
               return;
            }else {

            }
         }
      }
   }
}
