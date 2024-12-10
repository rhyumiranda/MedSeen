<script>
	import { setUser } from '../../stores/auth';
	import PocketBase from 'pocketbase';

	const pb = new PocketBase('http://127.0.0.1:8090');

	let firstName = '';
	let lastName = '';

	let email = '';
	let password = '';
	let passwordConfirm = '';

	const handleRegister = async (e) => {
    e.preventDefault();

    // Validate that passwords match
    if (password !== passwordConfirm) {
      alert('Passwords do not match. Please try again.');
      return;
    }

    const data = {
			email,
			password,
			passwordConfirm,
			emailVisibility: true,
			firstName,
			lastName,
		};

try {
    const newUser = await pb.collection('users').create(data);
    const authData = await pb.collection("users").authWithPassword(email, password);
		setUser(authData.record);
    console.log('User created successfully:', authData.record);
} catch (err) {
		console.log(data);
    console.error('Failed to create user:', err);
}
  };
</script>

<div class="flex min-h-full flex-col justify-center px-6 py-12 lg:px-8">
	<div class="sm:mx-auto sm:w-full sm:max-w-sm">
		<img
			class="mx-auto h-10 w-auto"
			src="https://tailwindui.com/plus/img/logos/mark.svg?color=indigo&shade=600"
			alt="Your Company"
		/>
		<h2 class="mt-10 text-center text-2xl/9 font-bold tracking-tight text-gray-900">
			Become a Member
		</h2>
	</div>

	<div class="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">
		<form on:submit={handleRegister} class="space-y-6" action="#" method="POST">
			<div class="flex justify-between">
				<div class="flex flex-col">
					<label for="firstName" class="block text-sm/6 font-medium text-gray-900">First Name</label
					>
					<div class="mt-2 flex flex-row">
						<input
							bind:value={firstName}
							type="text"
							name="firstName"
							id="firstName"
							autocomplete="email"
							required
							class="block w-full rounded-md bg-white px-3 py-1.5 text-base text-gray-900 outline outline-1 -outline-offset-1 outline-gray-300 placeholder:text-gray-400 focus:outline focus:outline-2 focus:-outline-offset-2 focus:outline-indigo-600 sm:text-sm/6"
						/>
					</div>
				</div>
				<div class="flex flex-col">
					<label for="lastName" class="block text-sm/6 font-medium text-gray-900">Last Name</label>
					<div class="mt-2 flex flex-row">
						<input
							bind:value={lastName}
							type="text"
							name="lastName"
							id="lastName"
							autocomplete="email"
							required
							class="block w-full rounded-md bg-white px-3 py-1.5 text-base text-gray-900 outline outline-1 -outline-offset-1 outline-gray-300 placeholder:text-gray-400 focus:outline focus:outline-2 focus:-outline-offset-2 focus:outline-indigo-600 sm:text-sm/6"
						/>
					</div>
				</div>
			</div>

			<div class="flex flex-col gap-2">
				<div>
					<div class="flex items-center justify-between">
						<label for="email" class="block text-sm/6 font-medium text-gray-900">Email</label>
					</div>
					<div class="mt-2">
						<input
							bind:value={email}
							type="email"
							name="email"
							id="email"
							autocomplete="email"
							required
							class="block w-full rounded-md bg-white px-3 py-1.5 text-base text-gray-900 outline outline-1 -outline-offset-1 outline-gray-300 placeholder:text-gray-400 focus:outline focus:outline-2 focus:-outline-offset-2 focus:outline-indigo-600 sm:text-sm/6"
						/>
					</div>
				</div>
				<div>
					<div class="flex items-center justify-between">
						<label for="password" class="block text-sm/6 font-medium text-gray-900">Password</label>
					</div>
					<div class="mt-2">
						<input
							bind:value={password}
							type="password"
							name="password"
							id="password"
							autocomplete="current-password"
							required
							class="block w-full rounded-md bg-white px-3 py-1.5 text-base text-gray-900 outline outline-1 -outline-offset-1 outline-gray-300 placeholder:text-gray-400 focus:outline focus:outline-2 focus:-outline-offset-2 focus:outline-indigo-600 sm:text-sm/6"
						/>
					</div>
				</div>
				<div>
					<div class="flex items-center justify-between">
						<label for="confirmPassword" class="block text-sm/6 font-medium text-gray-900"
							>Confirm Password</label
						>
					</div>
					<div class="mt-2">
						<input
							bind:value={passwordConfirm}
							type="password"
							name="passwordConfirm"
							id="passwordConfirm"
							autocomplete="current-password"
							required
							class="block w-full rounded-md bg-white px-3 py-1.5 text-base text-gray-900 outline outline-1 -outline-offset-1 outline-gray-300 placeholder:text-gray-400 focus:outline focus:outline-2 focus:-outline-offset-2 focus:outline-indigo-600 sm:text-sm/6"
						/>
					</div>
				</div>
			</div>

			<div>
				<button
					type="submit"
					class="flex w-full justify-center rounded-md bg-indigo-600 px-3 py-1.5 text-sm/6 font-semibold text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600"
					>Sign up</button
				>
			</div>
		</form>

		<p class="mt-10 text-center text-sm/6 text-gray-500">
			Already a Member?
			<a href="/login" class="font-semibold text-indigo-600 hover:text-indigo-500">Sign in</a
			>
		</p>
	</div>
</div>
