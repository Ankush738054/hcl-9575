import { useActionState } from "react";
import SubmitButton from "./SubmitButton";
import api from "./api";

const PostForm = ({ onCreated }) => {
  const submitAction = async (prev, formData) => {
    const title = formData.get("title")?.trim();
    const content = formData.get("content")?.trim();
    if (!title || !content) {
      return {
        error: "Title and content is required",
        msg: "",
        title: title || "",
        content: content || "",
      };
    }
    try {
      await api.post("/posts", { title, content });
      await onCreated?.();

      return {
        error: null,
        msg: "post created successfully",
        title: "",
        content: "",
      };
    } catch (error) {
      return {
        error:
          error.response?.data?.error ||
          error.response?.dta?.message ||
          "failed to create post. Please try again.",
        msg: "",
        title,
        content,
      };
    }
  };
  const [state, formAction, isPending] = useActionState(submitAction, {
    error: null,
    msg: "",
    title: "",
    content: "",
  });
  return (
    <form
      action={formAction}
      className="mx-auto w-full max-w-2xl space-y-5 rounded-3xl border border-orange-100 bg-white p-6 shadow-xl shadow-orange-950/5 sm:p-8"
    >
      <div>
        <p className="text-sm font-bold uppercase tracking-[0.18em] text-orange-600">
          Share an idea
        </p>
        <h3 className="mt-2 text-2xl font-black tracking-tight text-slate-900">
          Write a post
        </h3>
        <p className="mt-1 text-sm leading-6 text-slate-600">
          Put your thoughts into words and share them with the community.
        </p>
      </div>
      <div className="space-y-2">
        <label htmlFor="title" className="block text-sm font-semibold text-slate-700">
          Title
        </label>
        <input
          type="text"
          name="title"
          id="title"
          placeholder="Give your post a title"
          defaultValue={state.title}
          required
          disabled={isPending}
          className="w-full rounded-xl border border-slate-300 bg-white px-4 py-3 text-slate-900 outline-none transition placeholder:text-slate-400 focus:border-orange-500 focus:ring-4 focus:ring-orange-100 disabled:cursor-not-allowed disabled:bg-slate-50"
        />
      </div>
      <div className="space-y-2">
        <label htmlFor="content" className="block text-sm font-semibold text-slate-700">
          Your post
        </label>
        <textarea
          name="content"
          id="content"
          placeholder="What would you like to share?"
          rows={5}
          defaultValue={state.content}
          required
          disabled={isPending}
          className="w-full resize-y rounded-xl border border-slate-300 bg-white px-4 py-3 leading-6 text-slate-900 outline-none transition placeholder:text-slate-400 focus:border-orange-500 focus:ring-4 focus:ring-orange-100 disabled:cursor-not-allowed disabled:bg-slate-50"
        />
      </div>
      <SubmitButton />
      {state.msg && (
        <p
          role="status"
          className="rounded-xl border border-green-200 bg-green-50 px-4 py-3 text-sm text-green-700"
        >
          {state.msg}
        </p>
      )}
      {state.error && (
        <p
          role="alert"
          className="rounded-xl border border-red-200 bg-red-50 px-4 py-3 text-sm text-red-700"
        >
          {state.error}
        </p>
      )}
    </form>
  );
};
export default PostForm;