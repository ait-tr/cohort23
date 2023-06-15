import { configureStore, combineReducers } from "@reduxjs/toolkit";
import usersReducer from '../reducer/reducers';

const rootReducer = combineReducers({
    users: usersReducer
})

export const store = configureStore({
    reducer: rootReducer
})

export type RootState = ReturnType<typeof rootReducer>;
export default rootReducer;