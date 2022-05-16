import React from "react";

function App() {
  return (
    <div>
      <input type="text" />
      <button>search</button>
      <div>
        {process.env.REACT_APP_OPEN_SEARCH_URL}
      </div>
    </div>
  );
}

export default App;
