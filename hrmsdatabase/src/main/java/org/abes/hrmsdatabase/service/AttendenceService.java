package org.abes.hrmsdatabase.service;

import org.abes.hrmsdatabase.model.Attendance;
import org.abes.hrmsdatabase.repository.AttendenceRepository;
import org.abes.hrmsdatabase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendenceService {
    @Autowired
    private AttendenceRepository attendenceRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public String markAttendence(Attendance attendance){
        if (attendance == null || attendance.getEmployee() == null || attendance.getAttendancedate() == null) {
            return "Employee and attendance date are required";
        }

        long empId = attendance.getEmployee().getEmp_id();
        if (!employeeRepository.existsById(empId)) {
            return "Employee not found";
        }

        if (attendenceRepository.existsByEmployeeAndAttendancedate(
                attendance.getEmployee(), attendance.getAttendancedate())) {
            return "Attendance already marked for this employee on this date";
        }

        attendenceRepository.save(attendance);
        return "Attendance marked successfully";
    }

    public List<Attendance> getAttendanceByEmployeeId(Long empId) {
        return attendenceRepository.findByEmployeeId(empId);
    }
}
