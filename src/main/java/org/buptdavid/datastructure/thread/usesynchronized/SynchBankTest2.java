package org.buptdavid.datastructure.thread.usesynchronized;

import java.util.Vector;

/**
 * This program shows how multiple threads can safely access a data structure, using synchronized
 * methods.
 * @version 1.30 2004-08-01
 * @author Cay Horstmann
 */
public class SynchBankTest2
{
   public static void main(String[] args)
   {
      Bank b = new Bank(NACCOUNTS, INITIAL_BALANCE);
      int i;
      for (i = 0; i < NACCOUNTS; i++)
      {
         TransferRunnable r = new TransferRunnable(b, i, INITIAL_BALANCE);
         Thread t = new Thread(r);
         t.start();
      }
   }

   public static final int NACCOUNTS = 100;
   public static final double INITIAL_BALANCE = 1000;
}
