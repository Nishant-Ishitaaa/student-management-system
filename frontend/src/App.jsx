import { useState } from "react";
function App() {
  //   {
  //   "id": 1,
  //   "name": "John Doe",
  //   "course": "Computer Science"
  // }
  const [students, setStudents] = useState([]);
  const getStudentData = async () => {
    const response = await fetch("http://localhost:8080/student");
    const data = await response.json();
    // console.log(data);
    setStudents(data);
  };

  return (
    <div>
      <button onClick={getStudentData}>Get Student Data</button>
      <h1>this is student data:</h1>
      <ul>
   {students.map((student) => (
        <li key={student.id}>
           {student.name} - {student.course}
        </li>
        ))}
      </ul>
      
    </div>
  );
}

export default App;
