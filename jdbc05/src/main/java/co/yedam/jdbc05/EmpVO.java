package co.yedam.jdbc05;

import java.util.Date;

import lombok.Data;

//	@Getter
//	@Setter
//	@AllArgsConstructor
//	@NoArgsConstructor
	@Data
	public class EmpVO {
		private int employeeId; //employee_id
		private String firstName;
		private String lastName;
		private String email;
		private int salary;
		private Date hireDate;
		private String jobId;

}
