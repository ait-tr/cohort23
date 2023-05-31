import React from "react";
import "./App.css";
import Counter from "./Components/Counter";

const App: React.FC = () => {
  // dffvsd
    return (
        <div> {/* в return может быть вложен только 1 элемент на верхнем уровне */}
            <Counter />
        </div>
    );
}

export default App;
