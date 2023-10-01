//Adam Shaltout

/*
The number of people at a probability of 1.0 should be 366:
The first person will have a probability of 1.0 - 365/365 = 0,
when multiplying 365/365 by 364/365 and so on, the term will 
never reach 0, it will just become realy small. for example, with 
365 people, the equation will look like 1 - 365/365 * 364/365 * ... * 1/365, 
which is not yet 1.0 (though it is really close). Eventually, the 366th 
person will have a value of 0/365, which is equal to 0. Anything multiplied by 0 is 0,
so the equation 1 - 365/365 * 364/365 ... * 1/365 * 0/365 will be the same a 1.0 - 0, which is 1.0.
To sum up, 0.9999999999 is not equal to 1.0, no matter how many 9s. And when 
there are 366 people the birthday equation it will equal 1.0 exactly.
 */

class birthdays {
    public static void main(String[] args)
    {
        System.out.print("  PROBABILITY | # OF PEOPLE");
        double probability = 1;
        double term = 1;
        int index = 0;
        double[] currProb = {0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0};
        for (double j = 1; j <= 366; j++)
        {
            int count = 0;
            double i = 365;
            while (count < j)
            {
                term *= i/365;
                i -= 1;
                count += 1;
            }
            i = 365;
            if (index == 9)
            {
                if (term == 0)
                {
                    System.out.print("\n---------------------------");
                    System.out.print("\n     " + currProb[index] + "      |     " + (int)j + "      ");
                    index += 1;
                    j = 0;
                    term = 1;
                    break;
                }
            }

            if ((probability - term) > currProb[index] && index != 9)
            {
                System.out.print("\n---------------------------");
                System.out.print("\n     " + currProb[index] + "      |     " + (int)(j) + "      ");
                index += 1;
                j = 0;
                    
            }
            if (index > 9)
            {
                break;
            }
            term = 1;
        }
    }
}