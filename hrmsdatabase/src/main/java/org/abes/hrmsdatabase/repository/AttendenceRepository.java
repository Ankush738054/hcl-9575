package org.abes.hrmsdatabase.repository;

import org.abes.hrmsdatabase.model.Attendance;
import org.abes.hrmsdatabase.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface AttendenceRepository extends JpaRepository<Attendance, Long> {
    boolean existsByEmployeeAndAttendancedate(Employee employee, LocalDate attendancedate);

}
