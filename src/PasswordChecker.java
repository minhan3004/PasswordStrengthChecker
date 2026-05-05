public class PasswordChecker {

        public static String checkPasswordStrength(String password){
            
                if (password == null || password.isEmpty()) {
                    return "Lỗi: Mật khẩu không được để trống!";
                }
                int score = 0;
                StringBuilder feedback = new StringBuilder();
                // 1. kiểm tra độ dài
                if (password.length() >= 8) {
                    score = score + 1;
                    feedback.append("Độ Dài: Đủ (>= 8 ký tự)\n");
                } else {
                    feedback.append("Độ Dài: Quá Ngắn(< 8 ký tự)\n");
                }
                // 2.kiểm tra chữ hoa
                if (password.matches(".*[A-Z].*")) {
                    score = score + 1;
                    feedback.append("Chữ Hoa: Có\n");
                } else {
                    feedback.append("Chữ Hoa: Không có\n");
                }
                // 3.kiểm tra chữ thường
                if (password.matches(".*[a-z].*")) {
                    score = score + 1;
                    feedback.append("Chữ Thường: Có\n");
                } else {
                    feedback.append("Chữ Thường: Không có\n");
                }
                // 4.kiểm tra số
                if (password.matches(".*[0-9].*")) {
                    score=score + 1;
                    feedback.append("Số: Có\n");
                } else  {
                    feedback.append("Số: Không có\n");
                }
                // 5.kiểm tra ký tự đặc biệt
                if (password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
                    score = score + 1;
                    feedback.append("Ký tự đặc biệt: CÓ\n");
                } else {
                    feedback.append("Ký tự đặc biệt: Không có\n");
                }
                // Xác định cấp độ mật khẩu
                String strength = "";
                switch(score) {
                    case 0:
                    case 1: {
                        strength="Rất Yếu";
                        break;
                    }
                    case 2 : {
                        strength = "Yếu";
                        break;
                    } 
                    case 3 :  {
                        strength = "Trung Bình";
                        break;
                    }
                    case 4: {
                        strength = "Mạnh";
                        break;
                    } 
                    case 5: {
                        strength = "Rất Mạnh";
                        break;
                    }
                }
                return feedback.toString() + "\n Cấp độ: " + strength;
        }
        public static void main(String[] args) {
            System.out.println("=====================================");
            System.out.println("*** KIỂM TRA ĐỘ MẠNH CỦA MẬT KHẨU ***");
            System.out.println("=====================================");
            // nhập mật khẩu từ bàn phím 
            java.util.Scanner sc = new java.util.Scanner(System.in);

            while (true) {
                System.out.print("Nhập mật khẩu(hoặc 'exit' để thoát): ");
                String password = sc.nextLine();
                // kiểm tra nếu người dùng muốn thoát
                if(password.equalsIgnoreCase("exit")){
                    System.out.println("Tạm Biệt !!!");
                    break;
                }

                // kiểm tra độ mạnh của mật khẩu
                System.out.println(checkPasswordStrength(password));
                System.out.println("--------------------------------\n");
            }
            sc.close();
        }
}
