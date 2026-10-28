package org.abes.hrmsdatabase.controller;

import org.abes.hrmsdatabase.model.Attendance;
import org.abes.hrmsdatabase.service.AttendenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("v1/user/attendance")
public class AttendanceController {
    @Autowired
    private AttendenceService attendenceService;

    @PostMapping("/markattendance")
    public String markAttendance(@RequestBody Attendance attendance){
        return attendenceService.markAttendence(attendance);
    }
}
