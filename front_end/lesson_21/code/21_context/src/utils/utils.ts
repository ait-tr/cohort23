import React, { createContext } from "react";

export interface IUser {
    id: number;
    name: string;
}

// Создаём контекст в родительском компоненте, с помощью него будем передавать
// информацию дочерним элементам
export const UserContext = createContext<IUser[]>([]);