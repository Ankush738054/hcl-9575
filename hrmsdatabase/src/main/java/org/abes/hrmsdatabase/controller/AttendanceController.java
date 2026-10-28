package org.abes.hrmsdatabase.controller;

import org.abes.hrmsdatabase.model.Attendance;
import org.abes.hrmsdatabase.service.AttendenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("v1/user/attendance")
public class AttendanceController {
    @Autowired
    private AttendenceService attendenceService;

    @PostMapping("/markattendance")
    public String markAttendance(@RequestBody Attendance attendance){
        return attendenceService.markAttendence(attendance);
    }

    @GetMapping("/employee/{empId}")
    public List<AttendanceResponse> getAttendanceByEmployee(@PathVariable Long empId) {
        return attendenceService.getAttendanceByEmployeeId(empId).stream()
                .map(attendance -> new AttendanceResponse(
                        attendance.getAttendanceId(),
                        attendance.getAttendancedate(),
                        attendance.getInTime(),
                        attendance.getOutTime(),
                        attendance.getComment()
                ))
                .toList();
    }

    public record AttendanceResponse(
            Long attendanceId,
            LocalDate attendanceDate,
            LocalDateTime inTime,
            LocalDateTime outTime,
            String comment
    ) {
    }
}
