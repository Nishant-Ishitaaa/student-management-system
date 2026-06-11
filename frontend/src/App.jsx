import { useEffect, useState } from "react";

function App() {
  const [count, setCount] = useState(0);

  useEffect(() => {
    fetch("http://localhost:8080/student/count")
      .then((res) => res.json())
      .then((data) => setCount(data));
  }, []);

  return (
    <div>
      <h1>Total Students : {count} </h1>
    </div>
  );
}

export default App;
