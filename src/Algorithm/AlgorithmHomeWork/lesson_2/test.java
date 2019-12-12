package Algorithm.AlgorithmHomeWork.lesson_2;

public class test {
//	private static int n=7;
private static int n=5;
//	private static float pack = 15;
private static float pack = 10;
//	private static float[] p = new float[]{10,5,15,7,6,18,3};
    private static float[] p = new float[]{4, 4, 4, 2, 2};
//	private static float[] w = new float[]{2,3,5,7,1,4,1};
private static float[] w = new float[]{3, 3, 3, 5, 5};
	private static float[] p_after = new float[n];//按降序排好的P数组
	private static float[] w_after = new float[n];//按降序排好的weight数组
	private static int[] sortIndex = new int[n];
	private static float[] x = new float[n];//物品0~6 取走的比例
	private static int chose;// 0=>按比例降序放入背包   1=>按重量降序放入背包  2=>按 P/W 值降序放入背包
	private static float total = 0;// 总和
	public static void main(String args[]) {
		chose = 2;
		sort();
		for (int i =0; i<n; i++) System.out.println(sortIndex[i]);

		solution();
		for(int i=0; i<n; i++) {
			total += p[sortIndex[i]]*x[sortIndex[i]];
			System.out.println("排第"+ i +":p is " +p[sortIndex[i]] + ", w is "+ w[sortIndex[i]] + ", p/w is " + p[sortIndex[i]]/w[sortIndex[i]] + ",take "+x[sortIndex[i]]+" from 物品"+sortIndex[i]);
		}
		System.out.println("total is " +total);
	}

	public static void sort (){
		float[] p_w = new float[n];
		float max_pw;
		int time = n,max_index = 0;

		if(chose == 1)
			System.arraycopy(p,0,p_w,0,n);
		else if(chose == 2)
			System.arraycopy(p,0,p_w,0,n);
		else if(chose ==3) {
			for (int i = 0; i < n; i++) {
				p_w[i] = ((float) p[i] / (float) w[i]);
			}
		}

		while(time>0){
			max_pw = 0;
			max_index=0;
			for(int i=0;i<n;i++){
				if(p_w[i]>max_pw) {
					max_pw = p_w[i];
					max_index = i;
				}
			}

			p_after[n-time] = p[max_index];
			w_after[n-time] = w[max_index];
			sortIndex[n-time] = max_index;
			time--;
			p_w[max_index] = 0;
		}
	}

	public static void solution() {
		int i=0;

		for(i=0; i<n; i++) {
			if(w[sortIndex[i]] > pack)
				break;
			System.out.println(sortIndex[i]);
			x[sortIndex[i]] = 1;
			pack = pack - w[sortIndex[i]];
		}
		x[sortIndex[i]] = pack/w[sortIndex[i]];

	}



}
