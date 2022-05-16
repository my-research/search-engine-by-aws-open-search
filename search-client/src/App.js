import React from "react";

function App() {
  return (
    <div>
      <h1>
        hello world
      </h1>
      <div>
        {process.env.REACT_APP_OPEN_SEARCH_URL}
      </div>
    </div>
  );
}

export default App;
