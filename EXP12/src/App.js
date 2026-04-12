import React, { useState } from "react";
import AddStudent from "./components/AddStudent";
import StudentList from "./components/StudentList";

function App() {
  const [reload, setReload] = useState(false);

  const refresh = () => setReload(!reload);

  return (
    <div>
      <AddStudent refresh={refresh} />
      <StudentList reload={reload} />
    </div>
  );
}

export default App;