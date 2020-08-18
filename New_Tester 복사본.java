import java.io.*; 
import java.util.*; 
/**
 * Korean traditional card game called "suddta" is also known as "Korean BlackJack"
 * I wanted to figure out the winning rates for each possible hands.
 * this is a rough draft, but I am planning on making it overloaded version and stream version when I learn more coding
 * I want to become like Ed Soph one day.
 * If you have an insight just let me know.
 * This is the rulebook that I used- http://gostop.hangame.com/gameGuide/gssudda/guide_gssudda01_03.html
 * I still have to add Tied Situation feature and winning rate of each card when it was dealt first
 * 
 * @E-lazyer
 * @V 31
 */
public class New_Tester
{

    public static void main(String[] args) throws IOException 
    {
        StringBuffer fh1 = new StringBuffer("");
        StringBuffer fh2 = new StringBuffer("");
        StringBuffer fh3 = new StringBuffer("");
        StringBuffer fh4 = new StringBuffer("");
        StringBuffer fh5 = new StringBuffer("");
        StringBuffer fh6 = new StringBuffer("");
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int e = 0;
        int f = 0;
        // asks the user how many round they want it to calculate
        System.out.println("how many round?");
        Scanner pan = new Scanner(System.in); 
        int Pan_Number = pan.nextInt();
        String[] test = new String[6];
        ArrayList<Integer> Ggut = new ArrayList<Integer>();
        // this is the cards that are used in the game
        String[] pile = new String[]{"1G", "1 ","2 ", "2 ","3G", "3 ","4X", "4 ","5 ", "5 ","6 ", "6 ","7X", "7 ","8G", "8 ","9X", "9 ","10", "10"}; 
        ArrayList<String> Pile = new ArrayList<String>();
        for(int t = 0; t <pile.length; t++ )
        {
            Pile.add(pile[t]);
        }
        double[] count = new double[31];
        for(int i =0; i < 31; i++)
        {
            count[i] = 0.0;
        }
        // this is a possible hands for winning
        Map<String, Double> winnings= new LinkedHashMap<String, Double>();
        String max = "";

        winnings.put("38GG",count[0]);
        winnings.put("18GG",count[1]);
        winnings.put("13GG",count[2]);
        winnings.put("74XX",count[3]);
        winnings.put("10TT",count[4]);
        winnings.put("37TX",count[5]);
        winnings.put("99TT",count[6]);
        winnings.put("88TT",count[7]);
        winnings.put("77TT",count[8]);
        winnings.put("66TT",count[9]);
        winnings.put("55TT",count[10]);
        winnings.put("44TT",count[11]);
        winnings.put("33TT",count[12]);
        winnings.put("22TT",count[13]);
        winnings.put("11TT",count[14]);
        winnings.put("12Ai",count[15]);
        winnings.put("14DS",count[16]);
        winnings.put("19BB",count[17]);
        winnings.put("10BB",count[18]);
        winnings.put("104J",count[19]);
        winnings.put("46SR",count[20]);
        winnings.put("Gabo",count[21]);
        winnings.put("8Gut",count[22]);
        winnings.put("7Gut",count[23]);
        winnings.put("6Gut",count[24]);
        winnings.put("5Gut",count[25]);
        winnings.put("4Gut",count[26]);
        winnings.put("3Gut",count[27]);
        winnings.put("2Gut",count[28]);
        winnings.put("1Gut",count[29]);
        winnings.put("0Gut",count[30]);
        boolean aw = false;
        boolean gusax = false;
        boolean gusa = false;
        boolean testgusa = false; 

        for(int u = 0; u < Pan_Number ; u++)
        {
            // assigning each hands 2 cards for game
            for(int t = 0; t <pile.length; t++ )
            {
                Pile.add(pile[t]);
            }
            a = 0;

            fh1.delete(0, fh1.length());
            fh2.delete(0, fh2.length());
            fh3.delete(0, fh3.length());
            fh4.delete(0, fh4.length());
            fh5.delete(0, fh5.length());
            fh6.delete(0, fh6.length());

            a = (int)(Math.random()*((19-0)+1));
            fh1.append(Pile.get(a));
            Pile.remove(a);

            a = (int)(Math.random()*((18-0)+1));          
            fh2.append(Pile.get(a));
            Pile.remove(a);

            a = (int)(Math.random()*((17-0)+1));           
            fh3.append(Pile.get(a));
            Pile.remove(a);
            a = (int)(Math.random()*((16-0)+1));           
            fh4.append(Pile.get(a));
            Pile.remove(a);

            a = (int)(Math.random()*((15-0)+1));            
            fh5.append(Pile.get(a));
            Pile.remove(a);
            a = (int)(Math.random()*((14-0)+1));           
            fh6.append(Pile.get(a));
            Pile.remove(a);

            a = (int)(Math.random()*((13-0)+1));            
            fh1.append(" " + Pile.get(a));
            Pile.remove(a);

            a = (int)(Math.random()*((12-0)+1));          
            fh2.append(" " +Pile.get(a));
            Pile.remove(a);

            a = (int)(Math.random()*((11-0)+1));           
            fh3.append(" " +Pile.get(a));
            Pile.remove(a);
            a = (int)(Math.random()*((10-0)+1));          
            fh4.append(" " +Pile.get(a));
            Pile.remove(a);

            a = (int)(Math.random()*((9-0)+1));          
            fh5.append(" " +Pile.get(a));
            Pile.remove(a);
            a = (int)(Math.random()*((8-0)+1));          
            fh6.append(" " +Pile.get(a));
            Pile.clear();

            for(int t = 0; t <pile.length; t++ )
            {
                Pile.add(pile[t]);
            }

            test[0] = fh1.substring(0);
            test[1] = fh2.substring(0);
            test[2] = fh3.substring(0);
            test[3] = fh4.substring(0);
            test[4] = fh5.substring(0);
            test[5] = fh6.substring(0);
            
              
            Ggut.clear();
            // to check which comb. of cards won.
            for(int i = 0; i < test.length; i++)
            {  
                
                for(int j = 0; j < test.length; j++)
                {
                    if((test[j].substring(0,2).equals("4X") || test[j].substring(3).equals("4X")) && (test[j].substring(0,2).equals("9X") || test[j].substring(3).equals("9X")))
                    {
                        gusax = true;

                    }
                }
                for(int j = 0; j<1 ; j++)
                {
                    if((test[j].substring(0,2).equals("4X") || test[j].substring(3).equals("4X")||test[j].substring(0,2).equals("4 ")|| test[j].substring(3).equals("4 ")) && (test[j].substring(0,2).equals("9X") || test[j].substring(3).equals("9X") || test[j].substring(0,2).equals("9 ") || test[j].substring(3).equals("9 ")))
                    {
                        gusa = true;
                    }
                }
                if((test[i].substring(0,2).equals("3G") || test[i].substring(3).equals("3G"))&&(test[i].substring(0,2).equals("8G") || test[i].substring(3).equals("8G")))
                {
                    Ggut.add(30);
                    gusax = false;
                    gusa = false;
                }
                else if((test[i].substring(0,2).equals("1G") || test[i].substring(3).equals("1G"))&&(test[i].substring(0,2).equals("8G") || test[i].substring(3).equals("8G")))
                {
                    for(int j = 0; j < test.length; j++)
                    {
                        if((test[j].substring(0,2).equals("4X") || test[j].substring(3).equals("4X")) && (test[j].substring(0,2).equals("7X") || test[j].substring(3).equals("7X")))
                        {
                            aw = true ; 
                        }
                        
                    }
                    if(aw)
                    {
                        Ggut.add(27);
                        gusax = false;
                        gusa = false;
                        aw = false;
                    }
                    else
                    {
                        Ggut.add(29);
                        aw = false;
                        gusax = false;
                        gusa = false;
                    }
                }
                else if((test[i].substring(0,2).equals("1G") || test[i].substring(3).equals("1G"))&&(test[i].substring(0,2).equals("3G") || test[i].substring(3).equals("3G")))
                {
                    for(int j = 0; j < test.length; j++)
                    {
                        if((test[j].substring(0,2).equals("4X") || test[j].substring(3).equals("4X")) && (test[j].substring(0,2).equals("7X") || test[j].substring(3).equals("7X")))
                        {
                            aw = true ; 
                        }
                    }
                    if(aw)
                    {
                        Ggut.add(27);
                        gusax = false;
                        gusa = false;
                        aw = false;
                    }
                    else
                    {
                        Ggut.add(28);
                        aw = false;
                        gusax = false;
                        gusa = false;
                    }

                }

                else if(test[i].substring(0,2).equals("10") && test[i].substring(3).equals("10"))
                {
                    Ggut.add(26);
                    gusa = false;
                    aw = false;
                }

                else
                {
                    for(int j = 0; j < test.length; j++)
                    {
                        if((test[j].substring(0,2).equals("3G") || test[j].substring(3).equals("3G")) && (test[j].substring(0,2).equals("7X") || (test[j].substring(3).equals("7X"))))
                        {
                            aw = true ; 
                        }
                        else if((test[j].substring(0,2).equals("3G") || test[j].substring(3).equals("3G") && (test[j].substring(0,2).equals("7 ") || test[j].substring(3).equals("7 "))))
                        {
                            aw = true ; 
                        }
                        else if((test[j].substring(0,2).equals("3 ") || test[j].substring(3).equals("3 ") && (test[j].substring(0,2).equals("7X") || test[j].substring(3).equals("7X"))))
                        {
                            aw = true ; 
                        }
                        else if((test[j].substring(0,2).equals("3 ") || test[j].substring(3).equals("3 ") && (test[j].substring(0,2).equals("7 ") || test[j].substring(3).equals("7 "))))
                        {
                            aw = true ; 
                        }
                        else{aw= false;}

                    }
                    if(gusax)
                    {
                        Pan_Number++;
                        Ggut.clear();
                        break;
                    }
                    else{
                        if((test[i].substring(0,2).equals("9 ") ||test[i].substring(3).equals("9 "))&& (test[i].substring(0,2).equals("9X") ||test[i].substring(3).equals("9X")))
                        {
                            if(aw)
                            {
                                Ggut.add(25);
                                aw = false;
                                gusa = false;
                                
                            }
                            else
                            {
                                Ggut.add(24);
                                aw = false;
                                gusa = false;
                            }
                        }
                        else if((test[i].substring(0,2).equals("8 ") ||test[i].substring(3).equals("8 "))&&(test[i].substring(0,2).equals("8G") ||test[i].substring(3).equals("8G")))
                        {
                            if(aw)
                            {
                                Ggut.add(25);
                                aw = false;
                                gusa = false;
                            }
                            else
                            {
                                Ggut.add(23);
                                aw = false;
                                gusa = false;
                            }
                        }
                        else if((test[i].substring(0,2).equals("7 ") ||test[i].substring(3).equals("7 "))&&(test[i].substring(0,2).equals("7X") ||test[i].substring(3).equals("7X")))
                        {
                            if(aw)
                            {
                                Ggut.add(25);
                                aw = false;
                                gusa = false;
                            }
                            else{
                                Ggut.add(22);
                                aw = false;
                                gusa = false;
                            }
                        }
                        else if(test[i].substring(0,2).equals("6 ") && test[i].substring(3).equals("6 "))
                        {
                            if(aw)
                            {
                                Ggut.add(25);
                                aw = false;
                                gusa = false;
                            }
                            else{  
                                Ggut.add(21);
                                aw = false;
                                gusa = false;
                            }
                        }
                        else if(test[i].substring(0,2).equals("5 ") &&test[i].substring(3).equals("5 "))
                        {
                            if(aw)
                            {
                                Ggut.add(25);
                                aw = false;
                                gusa = false;
                            }
                            else{
                                Ggut.add(20);
                                aw = false;
                                gusa = false;
                            }
                        }
                        else if((test[i].substring(0,2).equals("4 ") ||test[i].substring(3).equals("4 "))&&(test[i].substring(0,2).equals("4X") ||test[i].substring(3).equals("4X")))
                        {
                            if(aw)
                            {
                                Ggut.add(25);gusa = false;aw = false;
                            }
                            else{ Ggut.add(19);
                                gusa = false;
                                aw = false;}
                        }
                        else if((test[i].substring(0,2).equals("3 ") ||test[i].substring(3).equals("3 "))&&(test[i].substring(0,2).equals("3G") ||test[i].substring(3).equals("3G")))
                        {
                            if(aw)
                            {
                                Ggut.add(25);gusa = false;aw = false;
                            }
                            else{Ggut.add(18);
                                gusa = false;
                                aw = false;}
                        }
                        else if(test[i].substring(0,2).equals("2 ") &&test[i].substring(3).equals("2 "))
                        {
                            if(aw)
                            { 
                                Ggut.add(25);gusa = false;aw = false;
                            }
                            else{Ggut.add(17);
                                gusa = false;
                                aw = false;}
                        }
                        else if((test[i].substring(0,2).equals("1 ") ||test[i].substring(3).equals("1 "))&&(test[i].substring(0,2).equals("1G") ||test[i].substring(3).equals("1G")))
                        {
                            if(aw)
                            {
                                Ggut.add(25);gusa = false;aw = false;
                            }
                            else{Ggut.add(16);
                                gusa = false;
                                aw = false;}
                        }

                        else if(gusa)
                        {
                            Pan_Number++;
                            Ggut.clear();
                            break;
                        }
                        else{
                            if((test[i].substring(0,2).equals("1G") || test[i].substring(3).equals("1G")||test[i].substring(0,2).equals("1 ") || test[i].substring(3).equals("1 "))&&(test[i].substring(0,2).equals("2 ") || test[i].substring(3).equals("2 ")))
                            {
                                Ggut.add(15);
                            }
                            else if((test[i].substring(0,2).equals("1G") || test[i].substring(3).equals("1G")||test[i].substring(0,2).equals("1 ") || test[i].substring(3).equals("1 "))&&(test[i].substring(0,2).equals("4 ") || test[i].substring(3).equals("4 ")))
                            {
                                Ggut.add(14);
                            }
                            else if(test[i].equals("1G 9X"))
                            {
                                Ggut.add(13);
                            }
                            else if(test[i].equals("1G 9 "))
                            {
                                Ggut.add(13);
                            }
                            else if(test[i].equals("1  9X"))
                            {
                                Ggut.add(13);
                            }
                            else if(test[i].equals("1  9 "))
                            {
                                Ggut.add(13);
                            }
                            else if((test[i].substring(0,2).equals("1G") || test[i].substring(3).equals("1G")||test[i].substring(0,2).equals("1 ") || test[i].substring(3).equals("1 "))&&(test[i].substring(0,2).equals("10") || test[i].substring(3).equals("10")))
                            {
                                Ggut.add(12);
                            }
                            else if((test[i].substring(0,2).equals("4X") || test[i].substring(3).equals("4X")||test[i].substring(0,2).equals("4 ") || test[i].substring(3).equals("4 "))&&(test[i].substring(0,2).equals("10") || test[i].substring(3).equals("10")))
                            {
                                Ggut.add(11);
                            }
                            else if((test[i].substring(0,2).equals("6 ") || test[i].substring(3).equals("6 ")) && (test[i].substring(0,2).equals("4X") || test[i].substring(3).equals("4X") || test[i].substring(0,2).equals("4 ") || test[i].substring(3).equals("4 ")))
                            {
                                Ggut.add(10);
                            }
                            else if(test[i].substring(0,2).equals("1G") || test[i].substring(0,2).equals("1 "))
                            {
                                Ggut.add(StartingOne(test[i].substring(3)));
                            }
                            else if(test[i].substring(0,2).equals("2 ") || test[i].substring(0,2).equals("2 "))
                            {
                                Ggut.add(StartingFour(test[i].substring(3)));
                            }
                            else if(test[i].substring(0,2).equals("3G") || test[i].substring(0,2).equals("3 "))
                            {
                                Ggut.add(StartingThree(test[i].substring(3)));
                            }
                            else if(test[i].substring(0,2).equals("4X") || test[i].substring(0,2).equals("4 "))
                            {
                                Ggut.add(StartingFour(test[i].substring(3)));
                            }
                            else if(test[i].substring(0,2).equals("5 ") || test[i].substring(0,2).equals("5 "))
                            {
                                Ggut.add(StartingFive(test[i].substring(3)));
                            }
                            else if(test[i].substring(0,2).equals("6 ") || test[i].substring(0,2).equals("6 "))
                            {
                                Ggut.add(StartingSix(test[i].substring(3)));
                            }    
                            else if(test[i].substring(0,2).equals("7 ") || test[i].substring(0,2).equals("7 "))
                            {
                                Ggut.add(StartingSeven(test[i].substring(3)));
                            }
                            else if(test[i].substring(0,2).equals("8G") || test[i].substring(0,2).equals("8 "))
                            {
                                Ggut.add(StartingEight(test[i].substring(3)));
                            }    
                            else if(test[i].substring(0,2).equals("9X") || test[i].substring(0,2).equals("9 "))
                            {
                                Ggut.add(StartingNine(test[i].substring(3)));
                            }
                            else if(test[i].substring(0,2).equals("10") || test[i].substring(0,2).equals("10"))
                            {
                                Ggut.add(StartingTen(test[i].substring(3)));
                            }
                        }
                    }
                }
            }
            if(Ggut.size() > 0)
            {
                max += Collections.max(Ggut);

                if(max.equals("30"))
                {
                    count[0] += 1;
                    winnings.replace("38GG",count[0]);
                }
                else if(max.equals("29")){
                    count[1] += 1;
                    winnings.replace("18GG",count[1]);
                }
                else if(max.equals("28"))
                {count[2] += 1;winnings.replace("13GG",count[2]);}
                else if(max.equals("27"))
                {count[3] += 1;winnings.replace("74XX",count[3]);}
                else if(max.equals("26"))
                {count[4] += 1;winnings.replace("10TT",count[4]);}
                else if(max.equals("25"))
                {count[5] += 1;winnings.replace("37TX",count[5]);}
                else if(max.equals("24"))
                {count[6] += 1;winnings.replace("99TT",count[6]);}
                else if(max.equals("23"))
                {count[7] += 1;winnings.replace("88TT",count[7]);}
                else if(max.equals("22"))
                {count[8] += 1;winnings.replace("77TT",count[8]);}
                else if(max.equals("21"))
                {count[9] += 1;winnings.replace("66TT",count[9]);}
                else if(max.equals("20"))
                {count[10] += 1;winnings.replace("55TT",count[10]);}
                else if(max.equals("19"))
                {count[11] += 1;winnings.replace("44TT",count[11]);}
                else if(max.equals("18"))
                {count[12] += 1;winnings.replace("33TT",count[12]);}
                else if(max.equals("17"))
                {count[13] += 1;winnings.replace("22TT",count[13]);}
                else if(max.equals("16"))
                {count[14] += 1;winnings.replace("11TT",count[14]);}
                else if(max.equals("15"))
                {count[15] += 1;winnings.replace("12Ai",count[15]);}
                else if(max.equals("14"))
                {count[16] += 1;winnings.replace("14DS",count[16]);}
                else if(max.equals("13"))
                {count[17] += 1;winnings.replace("19BB",count[17]);}
                else if(max.equals("12"))
                {count[18] += 1;winnings.replace("10BB",count[18]);}
                else if(max.equals("11"))
                {count[19] += 1;winnings.replace("104J",count[19]);}
                else if(max.equals("10"))
                {count[20] += 1;winnings.replace("46SR",count[20]);}
                else if(max.equals("9"))
                {count[21] += 1;winnings.replace("Gabo",count[21]);}
                else if(max.equals("8"))
                {count[22] += 1;winnings.replace("8Gut",count[22]);}
                else if(max.equals("7"))
                {count[23] += 1;winnings.replace("7Gut",count[23]);}
                else if(max.equals("6"))
                {count[24] += 1;winnings.replace("6Gut",count[24]);}
                else if(max.equals("5"))
                {count[25] += 1;winnings.replace("5Gut",count[25]);}
                else if(max.equals("4"))
                {count[26] += 1;winnings.replace("4Gut",count[26]);}
                else if(max.equals("3"))
                {count[27] += 1;winnings.replace("3Gut",count[27]);}
                else if(max.equals("2"))
                {count[28] += 1;winnings.replace("2Gut",count[28]);}
                else if(max.equals("1") || max.equals("31"))
                {count[29] += 1;winnings.replace("1Gut",count[29]);}
                else {count[30] += 1;winnings.replace("0Gut",count[30]);}
                
            }
            
            max = "";
        }
        for(Map.Entry m:winnings.entrySet())  
        {  
            System.out.println(m.getKey()+" "+m.getValue());   
        }
    }
    

    public static int StartingOne(String x)
    {
        if(x.equals("8 ") || x.equals("8G"))
        {return 9;}
        else if(x.equals("7X") ||x.equals("7 "))
        {return 8;}
        else if(x.equals("6 "))
        {return 7;}
        else if(x.equals("5 "))
        {return 6;}
        else if(x.equals("4X") || x.equals("4 "))
        {return 5;}
        else 
        {return 4;}

    }

    public static int StartingTwo(String x)
    {
        if(x.equals("8 ") || x.equals("8G"))
        {return 0;}
        else if(x.equals("7 "))
        {return 9;}
        else if(x.equals("6 "))
        {return 8;}
        else if(x.equals("5 "))
        {return 7;}
        else if(x.equals("4X") || x.equals("4 "))
        {return 6;}
        else if(x.equals("3 "))
        {return 5;}
        else{return 2;}

    }

    public static int StartingThree(String x)
    {
        if(x.equals("8 ") || x.equals("8G"))
        {return 1;}
        else if(x.equals("6 "))
        {return 9;}
        else if(x.equals("10"))
        {return 3;}
        else if(x.equals("5 "))
        {return 8;}
        else if(x.equals("4X") || x.equals("4 "))
        {return 7;}
        else if(x.equals("9X") || x.equals("9 "))
        {return 2;}
        else if(x.equals("1G") || x.equals("1 "))
        {return 4;}
        else if(x.equals("7X") ||x.equals("7 "))
        {return 0;}
        else{return 5;}

    }

    public static int StartingFour(String x)
    {
        if(x.equals("8 ") || x.equals("8G"))
        {return 2;}
        else if(x.equals("2 "))
        {return 6;}
        else if(x.equals("3 "))
        {return 7;}
        else if(x.equals("5 "))
        {return 9;}
        else{return 1;}

    }

    public static int StartingFive(String x)
    {
        if(x.equals("8 ") || x.equals("8G"))
        {return 3;}
        if(x.equals("3 ") || x.equals("3G"))
        {return 8;}
        else if(x.equals("6 "))
        {return 1;}
        else if(x.equals("10"))
        {return 5;}
        else if(x.equals("4X") || x.equals("4 "))
        {return 9;}
        else if(x.equals("9X") || x.equals("9 "))
        {return 4;}
        else if(x.equals("1G") || x.equals("1 "))
        {return 6;}
        else if(x.equals("7X") ||x.equals("7 "))
        {return 2;}
        else{return 7;}

    }

    public static int StartingSix(String x)
    {
        if(x.equals("8 ") || x.equals("8G"))
        {return 4;}
        if(x.equals("3 ") || x.equals("3G"))
        {return 9;} 
        else if(x.equals("10"))
        {return 6;}
        else if(x.equals("5 "))
        {return 1;}
        else if(x.equals("9X") || x.equals("9 "))
        {return 5;}
        else if(x.equals("1G") || x.equals("1 "))
        {return 7;}
        else if(x.equals("7X") ||x.equals("7 "))
        {return 3;}
        else{return 8;}

    }

    public static int StartingSeven(String x)
    {
        if(x.equals("8 ") || x.equals("8G"))
        {return 5;}
        else if(x.equals("6 "))
        {return 3;}
        else if(x.equals("10"))
        {return 7;}
        else if(x.equals("5 "))
        {return 2;}
        else if(x.equals("4X") || x.equals("4 "))
        {return 1;}
        else if(x.equals("9X") || x.equals("9 "))
        {return 6;}
        else if(x.equals("1G") || x.equals("1 "))
        {return 8;}
        else{return 9;}

    }

    public static int StartingEight(String x)
    {
        if(x.equals("6 "))
        {return 4;}
        else if(x.equals("10"))
        {return 8;}
        else if(x.equals("5 "))
        {return 3;}
        else if(x.equals("4X") || x.equals("4 "))
        {return 2;}
        else if(x.equals("9X") || x.equals("9 "))
        {return 7;}
        else if(x.equals("1G") || x.equals("1 "))
        {return 9;}
        else if(x.equals("7X") ||x.equals("7 "))
        {return 5;}
        else if(x.equals("3 ") || x.equals("3G"))
        {return 1;}
        else{return 0;}

    }

    public static int StartingNine(String x)
    {
        if(x.equals("8 ") || x.equals("8G"))
        {return 7;}
        else if(x.equals("6 "))
        {return 5;}
        else if(x.equals("10"))
        {return 9;}
        else if(x.equals("5 "))
        {return 4;}
        else if(x.equals("3 ") || x.equals("3G"))
        {return 2;}
        else if(x.equals("7X") ||x.equals("7 "))
        {return 6;}
        else{return 1;}

    }

    public static int StartingTen(String x)
    {
        if(x.equals("8 ") || x.equals("8G"))
        {return 8;}
        else if(x.equals("6 "))
        {return 6;}
        if(x.equals("3 ") || x.equals("3G"))
        {return 3;}
        else if(x.equals("5 "))
        {return 5;}
        else if(x.equals("9X") || x.equals("9 "))
        {return 9;}
        else if(x.equals("7X") ||x.equals("7 "))
        {return 7;}
        else{return 2;}

    }
    
}
