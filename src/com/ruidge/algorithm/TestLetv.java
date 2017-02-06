package com.ruidge.algorithm;

public class TestLetv {

	private final int i;
	private final TestLetv tl;

	public TestLetv(int i, TestLetv tl) {
		super();
		this.i = i;
		this.tl = tl;
	}

	public static void main(String[] args) {

		TestLetv self = new TestLetv(1, null);
		System.out.println(self.fib1(45));
		System.out.println(self.fib2(45));
		System.out.println(self.fib3(45));
//		 System.out.println(self.linear1(21));
//		 System.out.println(self.linear2(21));

	}

	/**
	 * if i == 1 || i == 2 return 1; if i > 2 return f(i - 1) + f(i - 2)
	 * 
	 * @param i
	 * @return
	 */
	public int fib1(int i) {
		if (i <= 0) {
			return 0;
		} else if (i == 1 || i == 2) {
			return 1;
		} else {
			return fib1(i - 1) + fib1(i - 2);
		}
	}

	//i是从1开始算起
	public int fib2(int i) {
		if (i <= 0) {
			return 0;
		} else if (i == 1 || i == 2) {
			return 1;
		} else {
			int a = 1;
			int b = 1;
			//下标3,i是从1算起
			int ii = 3;
			for (; ii <= i; ii++) {
				if (ii % 2 != 0) {
					a = a + b;
				} else {
					b = a + b;
				}
			}
            //此时i向后偏移1位
			System.out.println("i == ii- 1 : "+(i == ii - 1 ));
			if (ii % 2 == 0) {
				return a;
			} else {
				return b;
			}
		}

	}
    //i是从1开始算起
    public int fib3(int i) {
        if (i <= 0) {
            return 0;
        } else if (i == 1 || i == 2) {
            return 1;
        } else {
            int a = 1;
            int b = 1;
            //下标3,i是从1算起
            int ii = 3;
            for (; ii <= i; ii++) {
                if (ii % 2 == 0) {
                    a = a + b;
                } else {
                    b = a + b;
                }
            }
            if (i % 2 == 0) {
                return a;
            } else {
                return b;
            }
        }

    }

	public int linear1(int i) {
		if (i <= 0) {
			return -1;
		} else if (i == 1) {
			//初始值设为2
			return 2;
		} else {
			return linear1(i - 1) + 1;
		}
	}

	public int linear2(int i) {
		if (i <= 0) {
			return -1;
		}
		//初始值设为2
		int a = 2;
		for (int ii = 1; ii < i; ii++) {
			a = a + 1;
		}
		return a;

	}

}
