<script>
	import '../app.css';
	import { writable } from 'svelte/store';
	import { setUser, clearUser } from '../stores/auth';
	import pb from '../lib/pocket.js';
	let { children } = $props();
	

	if (pb.authStore.isValid) {
			console.log('Session is valid:', pb.authStore.model);
			setUser(pb.authStore.model);
	} else {
			console.log('No valid session');
			clearUser();
	}


</script>

{@render children()}

