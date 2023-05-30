import React from "react";
import "./App.css";
import MyComponent from "./components/MyComponent";
import ComponentA from "./components/ComponentA";
import Counter from "./components/Counter";

function App() {
    const name = "Bob Dylan";

    return (
        <>
            <h1>Hello, {name}!</h1>
            <p>This is an example of writing code in react</p>
            <MyComponent />
            <ComponentA />
            <Counter />
              {/*
            1. Комментарий в react выглядит так;
            2. Компоненты можно использовать бесконечное количество раз;
            3. Удобство синтаксиса (пишем в js шаблон текста как в html);
            */}
        </>
    );
}

export default App;
