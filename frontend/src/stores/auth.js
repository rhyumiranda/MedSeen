import { writable } from 'svelte/store';

export const user = writable(null);
export const isAuthenticated = writable(false);

export const setUser = (data) => {
    console.log('Setting user:', data);
    user.set(data);
    isAuthenticated.set(!!data);
    console.log('isAuthenticated:', !!data);
};


export const clearUser = () => {
    user.set(null);
    isAuthenticated.set(false);
};
