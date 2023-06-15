import {createSlice, PayloadAction} from '@reduxjs/toolkit';

interface IUser {
    id: number;
    name: string
}

interface IUsersState {
    users: IUser[];
    currentPage: number;
}

const initialState: IUsersState = {
    users: [],
    currentPage: 1
}

const userSlice = createSlice({
    name: 'users',
    initialState,
    reducers: {
        // описываем Action прямо здесь:
        // типизируем (PayloadAction = экшен с нагрузкой, нагрузка типа number)
        setPage(state, action: PayloadAction<number>) {
            state.currentPage = action.payload;
        }
    }
})

export const {setPage} = userSlice.actions
export default userSlice.reducer;