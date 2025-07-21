package com.example.face_recognition_applicaton.users.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users",
uniqueConstraints = {
    @UniqueConstraint(columnNames = "email", name = "email"),
    @UniqueConstraint(columnNames = "employeeId", name = "employee_id")
},
indexes = {
    @Index(name = "idx_user_email", columnList = "email"),
    @Index(name = "idx_user_employee_id", columnList = "employeeId")
})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 @NotBlank(message = "First name is mandatory")
	    @Size(max = 50, message = "First name cannot exceed 50 characters")
	    @Column(name = "first_name", nullable = false, length = 50)
	    private String firstName;

	    @NotBlank(message = "Last name is mandatory")
	    @Size(max = 50, message = "Last name cannot exceed 50 characters")
	    @Column(name = "last_name", length = 50)
	    private String lastName;

	    @Email(message = "Invalid email format")
	    @NotBlank(message = "Email is mandatory")
	    @Size(max = 100, message = "Email cannot exceed 100 characters")
	    @Column(name = "email", nullable = false, unique = true, length = 100)
	    private String email;

	    @NotBlank(message = "Password is mandatory")
	    @Size(min = 8, max = 255, message = "Password must be between 8 and 255 characters")
	    @Column(name = "password", nullable = false, length = 255)
	    private String password;

	    @Column(name = "role", nullable = false, length = 50)
	    private String role;

	    @Past(message = "Date of birth must be in the past")
	    @NotNull(message = "Date of birth is mandatory")
	    @Column(name = "date_of_birth", nullable = false)
	    private LocalDate dateOfBirth;

	    @Pattern(regexp = "^\\+[0-9]{10,15}$", message = "Phone number must start with + and be followed by 10-15 digits")
	    @NotBlank(message = "Phone number is mandatory")
	    @Size(max = 20, message = "Phone number cannot exceed 20 characters")
	    @Column(name = "phone_number", nullable = false, length = 20)
	    private String phoneNumber;

	    @PastOrPresent(message = "Hire date must be in the past or present")
	    @NotNull(message = "Hire date is mandatory")
	    @Column(name = "hire_date", nullable = false)
	    private LocalDate hireDate;

	    @Positive(message = "Salary must be positive")
	    @NotNull(message = "Salary is mandatory")
	    @Column(name = "salary", nullable = false, precision = 10, scale = 2)
	    private BigDecimal salary;

	    @NotNull(message = "Active status is mandatory")
	    @Column(name = "active", nullable = false)
	    private boolean active;

	    @NotBlank(message = "Employee ID is mandatory")
	    @Size(max = 50, message = "Employee ID cannot exceed 50 characters")
	    @Column(name = "employee_id", nullable = false, unique = true, updatable = false, length = 50)
	    private String employeeId;

	    @NotBlank(message = "Position is mandatory")
	    @Size(max = 100, message = "Position cannot exceed 100 characters")
	    @Column(name = "position", nullable = false, length = 100)
	    private String position;

	    @NotBlank(message = "Emergency contact name is mandatory")
	    @Size(max = 100, message = "Emergency contact name cannot exceed 100 characters")
	    @Column(name = "emergency_contact_name", nullable = false, length = 100)
	    private String emergencyContactName;

	    @Pattern(regexp = "^\\+[0-9]{10,15}$", message = "Emergency contact number must start with + and be followed by 10-15 digits")
	    @NotBlank(message = "Emergency contact number is mandatory")
	    @Size(max = 20, message = "Emergency contact number cannot exceed 20 characters")
	    @Column(name = "emergency_contact_number", nullable = false, length = 20)
	    private String emergencyContactNumber;

	    @NotBlank(message = "Nationality is mandatory")
	    @Size(max = 100, message = "Nationality cannot exceed 100 characters")
	    @Column(name = "nationality", nullable = false, length = 100)
	    private String nationality;

	    @NotNull(message = "Gender is mandatory")
	    @Column(name = "gender", nullable = false, length = 50)
	    private String gender;

	    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private List<Attendance> attendance;
	
}
