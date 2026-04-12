import React, { useEffect, useState } from "react";
import axios from "axios";

function StudentList({ reload }) {
  const [students, setStudents] = useState([]);

  const fetchStudents = () => {
    axios.get("http://localhost:8080/student")
      .then(res => {
        console.log("API DATA:", res.data); // 👈 DEBUG
        setStudents(res.data);
      })
      .catch(err => console.error(err));
  };

  useEffect(() => {
    fetchStudents();
  }, [reload]);

  const deleteStudent = (id) => {
    if (!id) {
      console.error("ID is undefined ❌");
      return;
    }

    console.log("Deleting ID:", id); // 👈 DEBUG

    axios.delete(`http://localhost:8080/student/${id}`)
      .then(() => fetchStudents())
      .catch(err => console.error(err));
  };

  return (
    <div>
      <h2>Student List</h2>

      <table border="1">
        <thead>
          <tr>
            <th>ID</th> 
            <th>Name</th>
            <th>Email</th>
            <th>Course</th>
            <th>Action</th>
          </tr>
        </thead>

        <tbody>
          {students.length > 0 ? (
            students.map((s, index) => (
              <tr key={s.id || index}> 
                <td>{s.id}</td> 
                <td>{s.name}</td>
                <td>{s.email}</td>
                <td>{s.course}</td>
                <td>
                  <button onClick={() => deleteStudent(s.id)}>
                    Delete
                  </button>
                </td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="5">No students found</td>
            </tr>
          )}
        </tbody>

      </table>
    </div>
  );
}

export default StudentList;