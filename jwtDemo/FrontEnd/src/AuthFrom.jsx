import { useActionState, useState } from 'react'
import api from './api'
import SubmitButton from './SubmitButton'

function AuthFrom() {
  const [mode, setMode] = useState('login')

  const submitAction = async (previousState, formData) => {
    const username = formData.get('username')?.trim() ?? ''
    const password = formData.get('password') ?? ''

    if (!username || !password.trim()) {
      return {
        error: 'Username and password are required.',
        message: '',
        username,
      }
    }

    try {
      if (mode === 'register') {
        const { data } = await api.post('/auth/register', { username, password })

        if (data.type === 'error') {
          return {
            error: data.message || 'Registration failed.',
            message: '',
            username,
          }
        }

        setMode('login')
        return {
          error: '',
          message: data.message || 'Registration successful. Please log in.',
          username,
        }
      }

      const { data } = await api.post('/auth/login', { username, password })

      if (!data.token || data.token === 'error') {
        return {
          error: data.username || 'Username or password is incorrect.',
          message: '',
          username,
        }
      }

      localStorage.setItem('token', data.token)
      return {
        error: '',
        message: `Welcome, ${data.username || username}!`,
        username: data.username || username,
      }
    } catch (error) {
      return {
        error:
          error.response?.data?.message ||
          error.response?.data?.error ||
          error.message ||
          'Unable to complete the request. Please try again.',
        message: '',
        username,
      }
    }
  }

  const [state, formAction] = useActionState(submitAction, {
    error: '',
    message: '',
    username: '',
  })

  return (
    <section className="relative mx-auto w-full max-w-md overflow-hidden rounded-3xl border border-orange-100 bg-white p-8 shadow-xl shadow-orange-950/5 sm:p-10">
      <div
        aria-hidden="true"
        className="absolute -right-12 -top-12 size-36 rounded-full bg-orange-100/70"
      />
      <div className="relative">
        <p className="text-sm font-bold uppercase tracking-[0.18em] text-orange-600">
          Little Spark
        </p>
        <h1 className="mt-3 text-3xl font-black tracking-tight text-slate-900">
          {mode === 'login' ? 'Welcome back' : 'Join the fun'}
        </h1>
        <p className="mt-2 text-sm leading-6 text-slate-600">
          {mode === 'login'
            ? 'Log in to pick up where your ideas left off.'
            : 'Create an account and get started.'}
        </p>

        <form action={formAction} className="mt-8 space-y-5">
          <div className="space-y-2">
            <label
              htmlFor="username"
              className="block text-sm font-semibold text-slate-700"
            >
              Username
            </label>
            <input
              id="username"
              name="username"
              type="text"
              autoComplete="username"
              defaultValue={state.username}
              required
              className="w-full rounded-xl border border-slate-300 bg-white px-4 py-3 text-slate-900 outline-none transition placeholder:text-slate-400 focus:border-orange-500 focus:ring-4 focus:ring-orange-100"
            />
          </div>

          <div className="space-y-2">
            <label
              htmlFor="password"
              className="block text-sm font-semibold text-slate-700"
            >
              Password
            </label>
            <input
              id="password"
              name="password"
              type="password"
              autoComplete={mode === 'login' ? 'current-password' : 'new-password'}
              required
              className="w-full rounded-xl border border-slate-300 bg-white px-4 py-3 text-slate-900 outline-none transition placeholder:text-slate-400 focus:border-orange-500 focus:ring-4 focus:ring-orange-100"
            />
          </div>

          {state.error && (
            <p
              role="alert"
              className="rounded-xl border border-red-200 bg-red-50 px-4 py-3 text-sm text-red-700"
            >
              {state.error}
            </p>
          )}
          {state.message && (
            <p
              role="status"
              className="rounded-xl border border-green-200 bg-green-50 px-4 py-3 text-sm text-green-700"
            >
              {state.message}
            </p>
          )}

          <SubmitButton />
        </form>

        <p className="mt-6 text-center text-sm text-slate-600">
          {mode === 'login' ? 'New around here?' : 'Already have an account?'}{' '}
          <button
            type="button"
            onClick={() => setMode((currentMode) => (currentMode === 'login' ? 'register' : 'login'))}
            className="font-semibold text-orange-700 underline-offset-4 transition hover:text-orange-800 hover:underline focus:outline-none focus-visible:rounded focus-visible:ring-2 focus-visible:ring-orange-500 focus-visible:ring-offset-2"
          >
            {mode === 'login' ? 'Create an account' : 'Log in'}
          </button>
        </p>
      </div>
    </section>
  )
}

export default AuthFrom
