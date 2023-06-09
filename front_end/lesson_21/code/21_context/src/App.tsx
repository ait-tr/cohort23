import React from "react";
import "./App.css";
import { IUser, UserContext } from "./utils/utils";
import UserOrders from "./components/UserOrders";


function App() { 
    // Создаем массив и типизируем его, для последующей передачи дочерним элементам
    const users: IUser[] = [
        { id: 1, name: "John Doe" },
        { id: 2, name: "Jane Smith" },
        { id: 3, name: "Mike Johnson" }
    ];

    return (
        <UserContext.Provider value={users}>
          {/* Provider в атрибуте value передаёт информацию users всем дочерним компонентам */}
          {/* Любой вложенный компонент имеет доступ до передаваемой информации */}
            <h1> User App </h1>
            <div>
                <UserOrders />
            </div>
        </UserContext.Provider>
    );
}

export default App;