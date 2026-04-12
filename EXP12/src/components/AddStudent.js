import React, { useState } from "react";
import axios from "axios";

function AddStudent({ refresh }) {
  const [student, setStudent] = useState({
    name: "",
    email: "",
    course: ""
  });

  const handleChange = (e) => {
    setStudent({ ...student, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    axios.post("http://localhost:8080/students", student)
      .then(() => {
        setStudent({ name: "", email: "", course: "" });
        refresh(); // refresh list
      });
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Add Student</h2>
      <input name="name" value={student.name} onChange={handleChange} placeholder="Name" />
      <input name="email" value={student.email} onChange={handleChange} placeholder="Email" />
      <input name="course" value={student.course} onChange={handleChange} placeholder="Course" />
      <button type="submit">Add</button>
    </form>
  );
}

export default AddStudent;