import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  async call<T, U>(
    method: 'GET' | 'POST' | 'PUT' | 'DELETE',
    path: string,
    body?: U,
  ): Promise<SuccessResponse<T> | FailedResponse> {
    const url = path;

    try {
      const response = await fetch(url, {
        method,
        body: JSON.stringify(body),
        headers: {
          'Content-Type': 'application/json',
        },
        signal: AbortSignal.timeout(10000),
      });

      if (!response.ok) {
        return {
          error: {
            message: response.statusText,
            code: response.status,
          },
          data: null,
        };
      }

      const data: T = await response.json();

      return {
        error: null,
        data,
      };
    } catch (err) {
      console.error(err);

      return {
        error: {
          message: 'connection_failed',
          code: 0,
        },
        data: null,
      };
    }
  }

  async get<T, U = undefined>(path: string, query?: U) {
    return this.call<T, U>('GET', path, query);
  }

  async post<T, U>(path: string, query?: U) {
    return this.call<T, U>('POST', path, query);
  }

  async put<T, U>(path: string, query?: U) {
    return this.call<T, U>('PUT', path, query);
  }

  async delete<T, U>(path: string, query?: U) {
    return this.call<T, U>('DELETE', path, query);
  }
}

interface SuccessResponse<T> {
  error: null;
  data: T;
}

interface FailedResponse {
  error: {
    message: string;
    code: number;
  };
  data: null;
}
