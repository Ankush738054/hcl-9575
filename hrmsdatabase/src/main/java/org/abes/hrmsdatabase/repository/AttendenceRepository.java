package org.abes.hrmsdatabase.repository;

import org.abes.hrmsdatabase.model.Attendance;
import org.abes.hrmsdatabase.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttendenceRepository extends JpaRepository<Attendance, Long> {
    boolean existsByEmployeeAndAttendancedate(Employee employee, LocalDate attendancedate);

    @Query("SELECT a FROM attendance a WHERE a.employee.emp_id = :empId")
    List<Attendance> findByEmployeeId(@Param("empId") Long empId);

}
