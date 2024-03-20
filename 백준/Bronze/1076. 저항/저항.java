import java.io.*;


public class Main {
    static String result ="";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // StringBuilder에 하나씩 붙여놓고 한 번에 출력하기

        StringBuilder value = twoInput(br, sb);
        String valueString = value.toString();
        long multiply = threeInput(br, sb);

        Long result = Integer.parseInt(valueString) * multiply;
        System.out.println(result);


    }

    private static long threeInput(BufferedReader br, StringBuilder sb) throws IOException {
        switch (br.readLine()) {
            case "black" -> {
                return (long) Math.pow(10,0);
            }
            case "brown" -> {
                return (long) Math.pow(10,1);
            }
            case "red" -> {
                return (long) Math.pow(10,2);
            }
            case "orange" -> {
                return (long) Math.pow(10,3);
            }
            case "yellow" -> {
                return (long) Math.pow(10,4);
            }
            case "green" -> {
                return (long) Math.pow(10,5);
            }
            case "blue" -> {
                return (long) Math.pow(10,6);
            }
            case "violet" -> {
                return (long) Math.pow(10,7);
            }
            case "grey" -> {
                return (long) Math.pow(10,8);
            }
            case "white" -> {
                return (long) Math.pow(10,9);
            }
        }
        return 0;
    }

    private static StringBuilder twoInput(BufferedReader br, StringBuilder sb) throws IOException {
        for (int i = 0; i < 2; i++) {
            switch (br.readLine()) {
                case "black" -> {
                    sb.append(result).append(0);
                }
                case "brown" -> {
                    sb.append(result).append(1);
                }
                case "red" -> {
                    sb.append(result).append(2);
                }
                case "orange" -> {
                    sb.append(result).append(3);
                }
                case "yellow" -> {
                    sb.append(result).append(4);
                }
                case "green" -> {
                    sb.append(result).append(5);
                }
                case "blue" -> {
                    sb.append(result).append(6);
                }
                case "violet" -> {
                    sb.append(result).append(7);
                }
                case "grey" -> {
                    sb.append(result).append(8);
                }
                case "white" -> {
                    sb.append(result).append(9);
                }
            }
        }
        return sb;
    }
}