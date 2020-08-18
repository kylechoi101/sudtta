import java.util.*;
import java.io.*;

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
 * @V 56
 */
public class V_56
{
    public static void main(String[] args)
    {
        int a = 0; 
        double x = 0.0; 
        ArrayList<Integer> Ggut = new ArrayList<Integer>();
        StringBuffer fh1 = new StringBuffer("");
        StringBuffer fh2 = new StringBuffer("");
        StringBuffer fh3 = new StringBuffer("");
        StringBuffer fh4 = new StringBuffer("");
        StringBuffer fh5 = new StringBuffer("");
        StringBuffer fh6 = new StringBuffer("");
        System.out.println("how many round?");
        Scanner pan = new Scanner(System.in); 
        int Pan_Number = pan.nextInt();
        int whole = Pan_Number;
        String[] round = new String[6];
        String[] pile = {"1G", "1 ","2 ", "2 ","3G", "3 ","4X", "4 ","5 ", "5 ","6 ", "6 ","7X", "7 ","8G", "8 ","9X", "9 ","10", "10"}; 
        String[] first_pile = {"1G", "1 ", "2 ","3G", "3 ","4X", "4 ", "5 ", "6 ","7X", "7 ","8G", "8 ","9X", "9 ","10"};
        ArrayList<String> Pile = new ArrayList<String>();
        double[] count = new double[31];
        double[] count2 = new double[16];
        Map<String, Double> hands= new LinkedHashMap<String, Double>();
        for(int i =0; i < 16; i++)
        {
            count2[i] = 0.0;
            hands.put(first_pile[i], count2[i]);
        }
        for(int i =0; i < 31; i++)
        {
            count[i] = 0.0;
        }
        // this is a possible hands for winning
        Map<String, Double> winnings= new LinkedHashMap<String, Double>();
        int max = 0;

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
        boolean isTTang = false;
        boolean aG = false;
        int OneG = 0;
        int One = 0;
        int Two = 0;
        int ThreeG = 0;
        int Three = 0;
        int FourX = 0;
        int Four = 0;
        int Five = 0;
        int Six = 0;
        int SevenX = 0;
        int Seven = 0;
        int EightG = 0; 
        int Eight = 0;
        int NineX = 0;
        int Nine = 0;
        int Ten = 0;
        Ggut.clear();
        for(int u = 0; u < Pan_Number ; u++)
        {
            for(int t = 0; t <pile.length; t++ )
            {
                Pile.add(pile[t]);
            }
            gusax = false;
            gusa = false;
            aw = false;
            aG =false;
            Ggut.clear();
            max = 0;
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

            round[0] = fh1.substring(0);
            round[1] = fh2.substring(0);
            round[2] = fh3.substring(0);
            round[3] = fh4.substring(0);
            round[4] = fh5.substring(0);
            round[5] = fh6.substring(0);
            for(int i = 0; i < round.length; i++)
            {
                if(round[i].substring(0,2).equals("1G"))
                {
                    OneG = StartingOneG(round[i].substring(3));
                    Ggut.add(OneG);
                }
                if(round[i].substring(0,2).equals("1 "))
                {
                    One = StartingOne(round[i].substring(3));
                    Ggut.add(One);
                }
                if(round[i].substring(0,2).equals("2 "))
                {   
                    Two = StartingTwo(round[i].substring(3));
                    Ggut.add(Two);
                }
                if(round[i].substring(0,2).equals("3G"))
                {
                    ThreeG = StartingThreeG(round[i].substring(3));
                    Ggut.add(ThreeG);
                }
                if(round[i].substring(0,2).equals("3 "))
                {
                    Three = StartingThree(round[i].substring(3));
                    Ggut.add(Three);
                }
                if(round[i].substring(0,2).equals("4X"))
                {
                    FourX = StartingFourX(round[i].substring(3));
                    Ggut.add(FourX);
                }
                if(round[i].substring(0,2).equals("4 "))
                {
                    Four = StartingFour(round[i].substring(3));
                    Ggut.add(Four);
                }
                if(round[i].substring(0,2).equals("5 "))
                {
                    Five = StartingFive(round[i].substring(3));
                    Ggut.add(Five);
                }
                if(round[i].substring(0,2).equals("6 "))
                {
                    Six = StartingSix(round[i].substring(3));
                    Ggut.add(StartingSix(round[i].substring(3)));
                }
                if(round[i].substring(0,2).equals("7X"))
                {
                    SevenX = StartingSevenX(round[i].substring(3));
                    Ggut.add(SevenX);
                }
                if(round[i].substring(0,2).equals("7 "))
                {
                    Seven = StartingSeven(round[i].substring(3));
                    Ggut.add(Seven);
                }
                if(round[i].substring(0,2).equals("8G "))
                {
                    EightG = StartingEightG(round[i].substring(3));
                    Ggut.add(EightG);
                }
                if(round[i].substring(0,2).equals("8 "))
                {
                    Eight = StartingEight(round[i].substring(3));
                    Ggut.add(Eight);
                }
                if(round[i].substring(0,2).equals("9X"))
                {
                    NineX = StartingNineX(round[i].substring(3));
                    Ggut.add(NineX);
                }
                if(round[i].substring(0,2).equals("9 "))
                {
                    Nine = StartingNine(round[i].substring(3));
                    Ggut.add(Nine);
                }
                if(round[i].substring(0,2).equals("10"))
                {
                    Ten = StartingTen(round[i].substring(3));
                    Ggut.add(Ten);
                }
                if(Ggut.size() > 5)
                {
                    if(Ggut.contains(-1))
                    {
                        aw = true;
                    }
                    if(Ggut.contains(-2))
                    {
                        gusa = true;
                    }
                    if(Ggut.contains(-3))
                    {
                        gusax = true;
                    }
                    if(Ggut.contains(-4))
                    {
                        aG = true;
                    }
                    max = Collections.max(Ggut);

                    if(max == OneG)
                    {
                        count2[0]++;
                        hands.replace (first_pile[0], count2[0]/whole);
                    }
                    else if(max == One)
                    {
                        count2[1]++;
                        hands.replace (first_pile[1], count2[1]/whole);
                    }
                    else if(max == Two)
                    {
                        count2[2]++;
                        hands.replace (first_pile[2], count2[2]/whole);
                    }
                    else if(max == ThreeG)
                    {
                        count2[3]++;
                        hands.replace (first_pile[3], count2[3]/whole);
                    }
                    else if(max == Three)
                    {
                        count2[4]++;
                        hands.replace (first_pile[4], count2[4]/whole);
                    }
                    else if(max == FourX)
                    {
                        count2[5]++;
                        hands.replace (first_pile[5], count2[5]/whole);
                    }
                    else if(max == Four)
                    {
                        count2[6]++;
                        hands.replace (first_pile[6], count2[6]/whole);
                    }
                    else if(max == Five)
                    {
                        count2[7]++;
                        hands.replace (first_pile[7], count2[7]/whole);
                    }
                    else if(max == Six)
                    {
                        count2[8]++;
                        hands.replace (first_pile[8], count2[8]/whole);
                    }
                    else if(max == SevenX)
                    {
                        count2[9]++;
                        hands.replace (first_pile[9], count2[9]/whole);
                    }
                    else if(max == Seven)
                    {
                        count2[10]++;
                        hands.replace (first_pile[10], count2[10]/whole);
                    }
                    else if(max == Ten)
                    {
                        count2[15]++;
                        hands.replace (first_pile[15], count2[15]/whole);
                    }
                    else if(max == Eight)
                    {
                        count2[12]++;
                        hands.replace (first_pile[12], count2[12]/whole);
                    }
                    else if(max == NineX)
                    {
                        count2[13]++;
                        hands.replace (first_pile[13], count2[13]/whole);
                    }
                    else if(max == Nine)
                    {
                        count2[14]++;
                        hands.replace (first_pile[14], count2[14]/whole);
                    }
                    else 
                    {
                        count2[11]++;
                        hands.replace (first_pile[11], count2[11]/whole);
                    }                    
                    if(max == 30)
                    {
                        count[0] += 1;
                        winnings.replace("38GG",count[0]/whole);
                    }
                    else if(max < 30 && max > 27)
                    {
                        if(aG)
                        {
                            count[3] += 1;winnings.replace("74XX",count[3]/whole);
                        }
                        else if( max == 29)
                        {
                            count[1] += 1;
                            winnings.replace("18GG",count[1]/whole);
                        }
                        else
                        {
                            count[2] += 1;winnings.replace("13GG",count[2]/whole);
                        }
                    }
                    else if(gusax)
                    {
                        Pan_Number++;
                        break;
                    }
                    else if(max == 26)
                    {
                        count[4] += 1;winnings.replace("10TT",count[4]/whole);
                    }
                    else if(max < 25 && max > 15)
                    {
                        if(aw)
                        {
                            count[5] += 1;winnings.replace("37TX",count[5]/whole);  
                        }
                        else if(max ==24)
                        {count[6] += 1;winnings.replace("99TT",count[6]/whole);}
                        else if(max==23)
                        {count[7] += 1;winnings.replace("88TT",count[7]/whole);}
                        else if(max==22)
                        {count[8] += 1;winnings.replace("77TT",count[8]/whole);}
                        else if(max==21)
                        {count[9] += 1;winnings.replace("66TT",count[9]/whole);}
                        else if(max==20)
                        {count[10] += 1;winnings.replace("55TT",count[10]/whole);}
                        else if(max==19)
                        {count[11] += 1;winnings.replace("44TT",count[11]/whole);}
                        else if(max==18)
                        {count[12] += 1;winnings.replace("33TT",count[12]/whole);}
                        else if(max==17)
                        {count[13] += 1;winnings.replace("22TT",count[13]/whole);}
                        else if(max==16)
                        {count[14] += 1;winnings.replace("11TT",count[14]/whole);}
                    }
                    else if(gusa)
                    {
                        Pan_Number++;
                        break;
                    }
                    else if(max==15)
                    {count[15] += 1;winnings.replace("12Ai",count[15]/whole);}
                    else if(max==14)
                    {count[16] += 1;winnings.replace("14DS",count[16]/whole);}
                    else if(max==13)
                    {count[17] += 1;winnings.replace("19BB",count[17]/whole);}
                    else if(max==12)
                    {count[18] += 1;winnings.replace("10BB",count[18]/whole);}
                    else if(max==11)
                    {count[19] += 1;winnings.replace("104J",count[19]/whole);}
                    else if(max==10)
                    {count[20] += 1;winnings.replace("46SR",count[20]/whole);}
                    else if(max==9)
                    {count[21] += 1;winnings.replace("Gabo",count[21]/whole);}
                    else if(max==8)
                    {count[22] += 1;winnings.replace("8Gut",count[22]/whole);}
                    else if(max==7)
                    {count[23] += 1;winnings.replace("7Gut",count[23]/whole);}
                    else if(max==6)
                    {count[24] += 1;winnings.replace("6Gut",count[24]/whole);}
                    else if(max==5)
                    {count[25] += 1;winnings.replace("5Gut",count[25]/whole);}
                    else if(max==4)
                    {count[26] += 1;winnings.replace("4Gut",count[26]/whole);}
                    else if(max==3)
                    {count[27] += 1;winnings.replace("3Gut",count[27]/whole);}
                    else if(max==2)
                    {count[28] += 1;winnings.replace("2Gut",count[28]/whole);}
                    else if(max==1)
                    {count[29] += 1;winnings.replace("1Gut",count[29]/whole);}
                    else {count[30] += 1;winnings.replace("0Gut",count[30]/whole);}
                }
            }

        }
        for(Map.Entry m:winnings.entrySet())  
        {  
            System.out.println(m.getKey()+" "+m.getValue());
            x += (double)m.getValue();
        }

        System.out.println("Rounds with gusa:" + (Pan_Number - whole));
        for(Map.Entry m:hands.entrySet())  
        {  
            System.out.println(m.getKey()+" "+m.getValue());   
        }
    }

    public static int StartingOneG(String x)
    {
        if(x.equals("8 "))
        {
            return 9;
        }
        else if(x.equals("1 "))
        {
            return 16;
        }
        else if(x.equals("8G"))
        {
            return 29;   
        }

        else if(x.equals("3G"))
        {
            return 28;
        }
        else if(x.equals("7X") ||x.equals("7 "))
        {
            return 8;
        }
        else if(x.equals("6 "))
        {
            return 7;
        }
        else if(x.equals("5 "))
        {
            return 6;
        }
        else if(x.equals("4X") || x.equals("4 "))
        {
            return 14;
        }
        else if(x.equals("9X") || x.equals("9 "))
        {
            return 13;
        }
        else if(x.equals("10"))
        {
            return 12;
        }
        else if(x.equals("2 "))
        {
            return 15;
        }
        else 
        {
            return 4;
        }

    }

    public static int StartingOne(String x)
    {
        if(x.equals("8 ")|| x.equals("8G"))
        {
            return 9;
        }
        else if(x.equals("1G"))
        {
            return 16;
        }
        else if(x.equals("7X") ||x.equals("7 "))
        {
            return 8;
        }
        else if(x.equals("6 "))
        {
            return 7;
        }
        else if(x.equals("5 "))
        {
            return 6;
        }
        else if(x.equals("4X") || x.equals("4 "))
        {
            return 14;
        }
        else if(x.equals("9X") || x.equals("9 "))
        {
            return 13;
        }
        else if(x.equals("2 "))
        {
            return 15;
        }
        else if(x.equals("10"))
        {
            return 12;
        }
        else 
        {
            return 4;
        }

    }

    public static int StartingTwo(String x)
    {
        if(x.equals("8 ") || x.equals("8G"))
        {
            return 0;
        }
        else if(x.equals("9X") || x.equals("9 "))
        {
            return 1;
        }
        else if(x.equals("7 "))
        {
            return 9;
        }
        else if(x.equals("6 "))
        {
            return 8;
        }
        else if(x.equals("5 "))
        {
            return 7;
        }
        else if(x.equals("4X") || x.equals("4 "))
        {
            return 6;
        }
        else if(x.equals("3 ") || x.equals("3G"))
        {
            return 5;
        }
        else if(x.equals("2 "))
        {
            return 17;
        }
        else if(x.equals("1G") || x.equals("1 "))
        {
            return 15;
        }
        else
        {
            return 2;
        }

    }

    public static int StartingThreeG(String x)
    {
        if(x.equals("8 "))
        {return 1;}
        else if(x.equals("8G"))
        {
            return 30;
        }
        else if(x.equals("6 "))
        {return 9;}
        else if(x.equals("5 "))
        {return 8;}
        else if(x.equals("4X") || x.equals("4 "))
        {return 7;}
        else if(x.equals("9X") || x.equals("9 "))
        {return 2;}
        else if(x.equals("10"))
        {return 3;}
        else if(x.equals("1G"))
        {return 28;}
        else if(x.equals("1 "))
        {return 4;} 
        else if(x.equals("7X") ||x.equals("7 "))
        {return -1;}
        else if(x.equals("3 "))
        {
            return 18;
        }
        else{return 5;}

    }

    public static int StartingThree(String x)
    {
        if(x.equals("8 ") || x.equals("8G"))
        {return 1;}
        else if(x.equals("6 "))
        {return 9;}
        else if(x.equals("5 "))
        {return 8;}
        else if(x.equals("4X") || x.equals("4 "))
        {return 7;}
        else if(x.equals("9X") || x.equals("9 "))
        {return 2;}
        else if(x.equals("10"))
        {return 3;}
        else if(x.equals("1G") || x.equals("1 "))
        {return 4;}
        else if(x.equals("7X") ||x.equals("7 "))
        {return -1;}
        else if(x.equals("3G"))
        {
            return 18;
        }
        else{return 5;}

    }

    public static int StartingFourX(String x)
    {
        if(x.equals("8 ") || x.equals("8G"))
        {return 2;}
        else if(x.equals("1G") || x.equals("1 "))
        {return 14;}
        else if(x.equals("2 "))
        {return 6;}
        else if(x.equals("9 "))
        {return -2;}
        else if(x.equals("9X"))
        {return -3;}
        else if(x.equals("10"))
        {return 11;}
        else if(x.equals("3 ") || x.equals("3G"))
        {return 7;}
        else if(x.equals("4 "))
        {return 19;}
        else if(x.equals("6 "))
        {return 10;}
        else if(x.equals("5 "))
        {return 9;}
        else if(x.equals("7X"))
        {return -4;}
        else{return 1;}

    }

    public static int StartingFour(String x)
    {
        if(x.equals("8 ") || x.equals("8G"))
        {return 2;}
        else if(x.equals("9 ") || x.equals("9X"))
        {return -2;}
        else if(x.equals("1G") || x.equals("1 "))
        {return 14;}
        else if(x.equals("2 "))
        {return 6;}
        else if(x.equals("3 ")|| x.equals("3G"))
        {return 7;}
        else if(x.equals("4X"))
        {return 19;}
        else if(x.equals("10"))
        {return 11;}
        else if(x.equals("5 "))
        {return 9;}
        else if(x.equals("6 "))
        {return 10;}
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
        else if(x.equals("5 "))
        {return 20;}
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
        else if(x.equals("6 "))
        {return 21;}
        else if(x.equals("4 ")|| x.equals("4X"))
        {return 10;}
        else{return 8;}

    }

    public static int StartingSevenX(String x)
    {
        if(x.equals("8 ") || x.equals("8G"))
        {return 5;}
        else if(x.equals("6 "))
        {return 3;}
        else if(x.equals("3 ") || x.equals("3G"))
        {return -1;}
        else if(x.equals("10"))
        {return 7;}
        else if(x.equals("5 "))
        {return 2;}
        else if(x.equals("4X"))
        {
            return -4;
        }
        else if(x.equals("4 "))
        {return 1;}
        else if(x.equals("7 "))
        {return 22;}
        else if(x.equals("9X") || x.equals("9 "))
        {return 6;}
        else if(x.equals("1G") || x.equals("1 "))
        {return 8;}
        else{return 9;}

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
        else if(x.equals("3 ") || x.equals("3G"))
        {return -1;}
        else if(x.equals("7X"))
        {return 22;}
        else if(x.equals("4X") || x.equals("4 "))
        {return 1;}
        else if(x.equals("9X") || x.equals("9 "))
        {return 6;}
        else if(x.equals("1G") || x.equals("1 "))
        {return 8;}
        else{return 9;}

    }

    public static int StartingEightG(String x)
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
        else if(x.equals("1G"))
        {return 29;}
        else if(x.equals("3G"))
        {return 30;}
        else if(x.equals("1 "))
        {return 9;}
        else if(x.equals("7X") ||x.equals("7 "))
        {return 5;}
        else if(x.equals("3 "))
        {return 1;}
        else if(x.equals("8 "))
        {return 23;}
        else{return 0;}

    }

    public static int StartingEight(String x)
    {
        if(x.equals("6 "))
        {return 4;}
        else if(x.equals("10"))
        {return 8;}
        else if(x.equals("5 "))
        {return 3;}
        else if(x.equals("8G"))
        {return 23;}
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

    public static int StartingNineX(String x)
    {
        if(x.equals("8 ") || x.equals("8G"))
        {return 7;}
        else if(x.equals("6 "))
        {return 5;}
        else if(x.equals("10"))
        {return 9;}
        else if(x.equals("5 "))
        {return 4;}
        else if(x.equals("9 "))
        {
            return 24;
        }
        else if(x.equals("4 "))
        {return -2;}
        else if(x.equals("4X"))
        {return -3;}
        else if(x.equals("3 ") || x.equals("3G"))
        {return 2;}
        else if(x.equals("1 ") || x.equals("1G"))
        {return 13;}
        else if(x.equals("7X") ||x.equals("7 "))
        {return 6;}
        else{return 1;}

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
        else if(x.equals("4 ") || x.equals("4X"))
        {return -2;}
        else if(x.equals("9X"))
        {return 24;}
        else if(x.equals("3 ") || x.equals("3G"))
        {return 2;}
        else if(x.equals("1 ") || x.equals("1G"))
        {return 13;}
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
        else if(x.equals("1 ") || x.equals("1G"))
        {return 12;}
        else if(x.equals("4X") || x.equals("4 "))
        {return 16;}
        else if(x.equals("10"))
        {return 26;}
        else{return 2;}

    }
}
