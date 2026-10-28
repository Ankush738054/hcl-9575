import { useEffect, useState } from "react";
import { useLocation } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";

function Dashboard() {
  const { state } = useLocation();
  const [attendance, setAttendance] = useState([]);
  const [isLoading, setIsLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    async function getAttendance() {
      if (!state?.empId) {
        setError("Employee ID is unavailable. Please log in again.");
        setIsLoading(false);
        return;
      }

      try {
        const response = await fetch(
          `http://localhost:8080/v1/user/attendance/employee/${encodeURIComponent(state.empId)}`,
        );
        if (!response.ok) {
          throw new Error("Unable to load attendance data.");
        }
        setAttendance(await response.json());
      } catch (requestError) {
        console.error("Attendance request failed:", requestError);
        setError("Unable to load attendance data. Please try again later.");
      } finally {
        setIsLoading(false);
      }
    }

    getAttendance();
  }, [state?.empId]);

  return (
    <main className="container-fluid min-vh-100 bg-body-tertiary py-5">
      <div className="container">
        <div className="card border-0 shadow-sm rounded-4 mb-4">
          <div className="card-body p-4 p-md-5">
            <p className="text-primary fw-semibold mb-2">HRMS</p>
            <h1 className="h3 mb-2">Welcome to your dashboard</h1>
            <p className="text-secondary mb-4">
              You are logged in. Use this page as your starting point.
            </p>
            {state?.empId && (
              <div className="border rounded-3 p-3">
                <span className="text-secondary">Employee ID</span>
                <div className="fw-semibold">{state.empId}</div>
              </div>
            )}
          </div>
        </div>
        <div className="card border-0 shadow-sm rounded-4">
          <div className="card-body p-4">
            <h2 className="h4 mb-3">Attendance</h2>
            {isLoading ? (
              <p className="text-secondary mb-0">Loading attendance...</p>
            ) : error ? (
              <p className="text-danger mb-0" role="alert">{error}</p>
            ) : attendance.length === 0 ? (
              <p className="text-secondary mb-0">No attendance records found.</p>
            ) : (
              <div className="table-responsive">
                <table className="table table-striped align-middle mb-0">
                  <thead>
                    <tr>
                      <th scope="col">Date</th>
                      <th scope="col">In time</th>
                      <th scope="col">Out time</th>
                      <th scope="col">Comment</th>
                    </tr>
                  </thead>
                  <tbody>
                    {attendance.map((record) => (
                      <tr key={record.attendanceId}>
                        <td>{record.attendanceDate}</td>
                        <td>{record.inTime ? new Date(record.inTime).toLocaleTimeString() : "-"}</td>
                        <td>{record.outTime ? new Date(record.outTime).toLocaleTimeString() : "-"}</td>
                        <td>{record.comment || "-"}</td>
                      </tr>
                    ))}
                  </tbody>
                </table>
              </div>
            )}
          </div>
        </div>
      </div>
    </main>
  );
}

export default Dashboard;
